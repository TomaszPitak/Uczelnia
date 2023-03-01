package DatabaseQueries;

import Entities.*;
import Interfaces.KierunekService;
import Singleton.SingletonConnection;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import javafx.scene.control.Alert;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.hibernate.Transaction;

/**
 * Zawiera metody dla tabeli kierunki.
 *
 * @author Tomasz Pitak
 */
public class KierunekMethods implements KierunekService {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public KierunekMethods() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Pobiera z bazy danych kierunki według nazwy.
     *
     * @param nazwa nazwa kierunku
     * @return kierunek
     */
    @Override
    public Kierunek wyszukajWgNazwy(String nazwa) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kierunek k = (Kierunek) session.createSQLQuery("select * from kierunki where nazwa=\'" + nazwa + "\'").addEntity(Kierunek.class).uniqueResult();

        session.getTransaction().commit();
        session.close();

        return k;
    }

    /**
     * Zapisuje kierunek do bazy danych.
     *
     * @param nazwa
     * @param nazwaKolegium
     * @return dodany kierunek
     */
    @Override
    public Kierunek saveKierunek(String nazwa, String nazwaKolegium) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kolegium kol = (Kolegium) session.createSQLQuery("select * from kolegia where nazwa=\'" + nazwaKolegium + "\'").addEntity(Kolegium.class).getSingleResult();
        Kierunek k = new Kierunek(kol, nazwa);

        session.save(k);

        session.getTransaction().commit();
        session.close();

        return k;
    }

    /**
     * Aktualizuje kierunek w bazie danych. 
     *
     * @param nazwa
     * @param nazwaKolegium
     * @param idKierunku
     */
    @Override
    public void updateKierunek(String nazwa, String nazwaKolegium, String idKierunku) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kierunek kierunek = (Kierunek) session.createSQLQuery("select * from kierunki where idKierunku=\'" + idKierunku + "\'").addEntity(Kierunek.class).getSingleResult();
        Kolegium kolegium = (Kolegium) session.createSQLQuery("select * from kolegia where nazwa=\'" + nazwaKolegium + "\'").addEntity(Kolegium.class).getSingleResult();

        //aktualizacja parametrów kierunku
        kierunek.setNazwa(nazwa);
        kierunek.setIdKolegium(kolegium);

        //update obiektu kierunek
        session.update(kierunek);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Usuwa kierunek z bazy danych. 
     *
     * @param kierunek
     * @return true - jeśli pomyślnie usunięto;
     *         false - jeśli wystąpiły błędy
     */
    @Override
    public boolean deleteKierunek(Kierunek kierunek) {
        session = sessionFactory.openSession();
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.flush();

            session.delete(kierunek);

            transaction.commit();
            result = true;
        } catch (PersistenceException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Rekord jest używany przez inne tabele");
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Pobiera nazwy kierunków z bazy danych według nazwy kolegium.
     *
     * @param nazwaKolegium 
     * @return lista nazw kierunków
     */
    @Override
    public ArrayList<String> pobierzKierunki(String nazwaKolegium) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kolegium k = (Kolegium) session.createSQLQuery("select * from kolegia where nazwa=\'" + nazwaKolegium + "\'").addEntity(Kolegium.class).uniqueResult();

        List<Kierunek> lista = session.createSQLQuery("select * from kierunki where idKolegium=\'" + k.getIdKolegium() + "\'").addEntity(Kierunek.class).list();
        ArrayList<String> kierunki = new ArrayList<>();
        //pobranie samych nazw
        for (int i = 0; i < lista.size(); i++) {
            kierunki.add(lista.get(i).getNazwa());
        }

        session.getTransaction().commit();
        session.close();

        return kierunki;
    }

    /**
     * Pobiera wszystkie nazwy kierunków z bazy danych.
     *
     * @return lista nazw kierunków
     */
    @Override
    public ArrayList<String> pobierzKierunki2() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Kierunek> lista = session.createSQLQuery("select * from kierunki").addEntity(Kierunek.class).list();
        ArrayList<String> kierunki = new ArrayList<>();
        //pobranie samych nazw
        for (int i = 0; i < lista.size(); i++) {
            kierunki.add(lista.get(i).getNazwa());
        }

        session.getTransaction().commit();
        session.close();

        return kierunki;
    }

    /**
     * Sprawdza czy w bazie istanieje kierunek o danej nazwie.
     *
     * @param nazwa 
     * @return true/false
     */
    @Override
    public boolean wyszukajKierunek(String nazwa) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.flush();
            Kierunek k = (Kierunek) session.createSQLQuery("select * from kierunki where nazwa=\'" + nazwa + "\'").addEntity(Kierunek.class).getSingleResult();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

}
