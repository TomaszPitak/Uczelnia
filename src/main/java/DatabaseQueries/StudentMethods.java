package DatabaseQueries;

import Entities.*;
import Interfaces.StudentService;
import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import javax.persistence.NoResultException;

/**
 * Zawiera metody dla tabeli studenci.
 *
 * @author Tomasz Pitak
 */
public class StudentMethods implements StudentService {

    private SessionFactory sessionFactory;
    private Session session;

    public StudentMethods() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Pobiera z bazy danych studentów według peselu.
     *
     * @param pesel
     * @return lista studentów
     */
    @Override
    public List<Student> wyszukajWgPeselu(String pesel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Student> s = session.createSQLQuery("select * from studenci where pesel=\'" + pesel + "\'").addEntity(Student.class).list();

        session.getTransaction().commit();
        session.close();

        return s;
    }

    /**
     * Pobiera z bazy danych studentów według nazwiska.
     *
     * @param nazwisko
     * @return lista studentów
     */
    @Override
    public List<Student> wyszukajWgNazwiska(String nazwisko) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Student> s = session.createSQLQuery("select * from studenci where upper(nazwisko)=upper(\'" + nazwisko + "\')").addEntity(Student.class).list();

        session.getTransaction().commit();
        session.close();

        return s;
    }

    /**
     * Pobiera z bazy danych studentów według nazwy kierunku.
     *
     * @param nazwaKierunku
     * @return lista studentów
     */
    @Override
    public List<Student> wyszukajWgKierunku(String nazwaKierunku) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Student> s = session.createSQLQuery("select * from studenci where idKierunku = (select idKierunku from kierunki where upper(nazwa) = upper(\'" + nazwaKierunku + "\')) order by nazwisko asc").addEntity(Student.class).list();

        session.getTransaction().commit();
        session.close();

        return s;
    }

    /**
     * Zapisuje studenta do bazy danych.
     *
     * @param nazwaKierunku
     * @param nazwaKolegium
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param miejscowosc
     * @param ulica
     * @param nrMieszkania
     * @param nrTelefonu
     * @param email
     * @param nrSemestru
     * @param nrAlbumu
     * @return dodany student
     */
    @Override
    public Student saveStudent(String nazwaKierunku, String nazwaKolegium,String imie, String nazwisko,String pesel, String miejscowosc,String ulica, String nrMieszkania, String nrTelefonu, String email, String nrSemestru, String nrAlbumu) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kierunek kie;
        Kolegium kol;
        Student s;

        kol = (Kolegium) session.createSQLQuery("select * from kolegia where upper(nazwa)=upper(\'" + nazwaKolegium + "\')").addEntity(Kolegium.class).getSingleResult();
        kie = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).getSingleResult();
        s = new Student(kie, kol, imie, nazwisko, pesel, miejscowosc, ulica, nrMieszkania, nrTelefonu, email, nrSemestru, nrAlbumu);

        session.save(s);

        session.getTransaction().commit();
        session.close();

        return s;
    }

    /**
     * Aktualizuje studenta w bazie danych. 
     *
     * @param nazwaKierunku
     * @param nazwaKolegium
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param miejscowosc
     * @param ulica
     * @param nrMieszkania
     * @param nrTelefonu
     * @param email
     * @param nrSemestru
     * @param nrAlbumu
     * @param idStudenta
     */
    @Override
    public void updateStudent(String nazwaKierunku, String nazwaKolegium, String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String nrTelefonu, String email, String nrSemestru, String nrAlbumu, String idStudenta) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kierunek kierunek = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).getSingleResult();
        Kolegium kolegium = (Kolegium) session.createSQLQuery("select * from kolegia where upper(nazwa)=upper(\'" + nazwaKolegium + "\')").addEntity(Kolegium.class).getSingleResult();
        Student student = (Student) session.createSQLQuery("select * from studenci where idStudenta=\'" + idStudenta + "\'").addEntity(Student.class).getSingleResult();

        //aktualizacja parametrów studenta
        student.setImie(imie);
        student.setNazwisko(nazwisko);
        student.setPesel(pesel);
        student.setMiasto(miejscowosc);
        student.setUlica(ulica);
        student.setNrMieszkania(nrMieszkania);
        student.setNrTelefonu(nrTelefonu);
        student.setEmail(email);
        student.setNrSemestru(nrSemestru);
        student.setNrAlbumu(nrAlbumu);
        student.setIdKierunku(kierunek);
        student.setIdKolegium(kolegium);

        //update obiektu student
        session.update(student);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Usuwa studenta z bazy danych. 
     *
     * @param student
     */
    @Override
    public void deleteStudent(Student student) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        session.delete(student);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Sprawdza czy w bazie istnieje student o danym peselu.
     *
     * @param pesel 
     * @return true/false
     */
    @Override
    public boolean wyszukajStudenta(String pesel) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.flush();
            Student s = (Student) session.createSQLQuery("select * from studenci where pesel=\'" + pesel + "\'").addEntity(Student.class).getSingleResult();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

}
