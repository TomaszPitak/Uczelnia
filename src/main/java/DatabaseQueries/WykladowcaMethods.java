package DatabaseQueries;

import Entities.*;
import Interfaces.WykladowcaService;
import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import javax.persistence.NoResultException;

/**
 * Zawiera metody dla tabeli wykładowcy.
 *
 * @author Tomasz Pitak
 */
public class WykladowcaMethods implements WykladowcaService {    
    private SessionFactory sessionFactory;
    private Session session;

    public WykladowcaMethods() {
         this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Pobiera z bazy danych wykładowców według peselu.
     *
     * @param pesel
     * @return lista wykładowców
     */
    @Override
    public List<Wykladowca> wyszukajWgPeselu(String pesel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Wykladowca> w = session.createSQLQuery("select * from wykladowcy where pesel=\'" + pesel+ "\'").addEntity(Wykladowca.class).list();

        session.getTransaction().commit();
        session.close();

        return w;
    }
    
    /**
     * Pobiera z bazy danych wykładowców według nazwiska.
     *
     * @param nazwisko
     * @return lista wykładowców
     */
    @Override
    public List<Wykladowca> wyszukajWgNazwiska(String nazwisko) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Wykladowca> w = session.createSQLQuery("select * from wykladowcy where upper(nazwisko)=upper(\'" + nazwisko+ "\')").addEntity(Wykladowca.class).list();

        session.getTransaction().commit();
        session.close();

        return w;
    }
    
     /**
     * Zapisuje wykładowce do bazy danych.
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param miejscowosc
     * @param ulica
     * @param nrMieszkania
     * @param pensja
     * @param nrTelefonu
     * @param email
     * @param stopien
     * @return dodany wykładowca
     */
    @Override
    public Wykladowca saveWykladowca(String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String pensja, String nrTelefonu, String email, String stopien) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Wykladowca w = new Wykladowca(imie,nazwisko,pesel, miejscowosc,ulica,nrMieszkania,nrTelefonu,email,Integer.parseInt(pensja),stopien);

        session.save(w);

        session.getTransaction().commit();
        session.close();

        return w;
    }
    
     /**
     * Aktualizuje wykładowce w bazie danych. 
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param miejscowosc
     * @param ulica
     * @param nrMieszkania
     * @param pensja
     * @param nrTelefonu
     * @param email
     * @param stopien
     * @param idWykladowcy
     */
    @Override
    public void updateWykladowca(String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String pensja, String nrTelefonu, String email, String stopien, String idWykladowcy) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Wykladowca wykladowca = (Wykladowca) session.createSQLQuery("select * from wykladowcy where idWykladowcy=\'" + idWykladowcy+ "\'").addEntity(Wykladowca.class).getSingleResult();
       
        //aktualizacja parametrów wykladowcy
        wykladowca.setImie(imie);
        wykladowca.setNazwisko(nazwisko);
        wykladowca.setPesel(pesel);
        wykladowca.setMiasto(email);
        wykladowca.setUlica(ulica);
        wykladowca.setNumerMieszkania(nrMieszkania);
        wykladowca.setPensja(Integer.parseInt(pensja));
        wykladowca.setNumerTelefonu(nrTelefonu);
        wykladowca.setEmail(email);
        wykladowca.setStopien(stopien);

        //update obiektu wykladowca
        session.update(wykladowca);

        session.getTransaction().commit();
        session.close();
    }
    
    /**
     * Usuwa wykładowcę z bazy danych. 
     *
     * @param wykladowca
     */
    @Override
    public void deleteWykladowca(Wykladowca wykladowca) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();
        
        session.delete(wykladowca);
        
        session.getTransaction().commit();
        session.close();
    }
    
    /**
     * Sprawdza czy w bazie istnieje wykładowca o danym peselu.
     *
     * @param pesel 
     * @return true/false
     */
    @Override
    public boolean wyszukajWykladowce(String pesel) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.flush();
            Wykladowca w = (Wykladowca) session.createSQLQuery("select * from wykladowcy where pesel=\'" + pesel+ "\'").addEntity(Wykladowca.class).getSingleResult();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

}

