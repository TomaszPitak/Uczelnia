package DatabaseQueries;

import Entities.*;
import Interfaces.WykladanyPrzedmiotService;
import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import javafx.scene.control.Alert;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.hibernate.Transaction;

/**
 * Zawiera metody dla tabeli wykładanePrzedmioty.
 *
 * @author Tomasz Pitak
 */
public class WykladanyPrzedmiotMethods implements WykladanyPrzedmiotService {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public WykladanyPrzedmiotMethods() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

     /**
     * Zapisuje wykładany przedmiot do bazy danych.
     *
     * @param peselWykladowcy
     * @param nazwaPrzedmiotu
     * @param nazwaKierunku
     * @return dodany obiekt
     */
    @Override
    public WykladanyPrzedmiot saveWykladanyPrzedmiot(String peselWykladowcy, String nazwaPrzedmiotu, String nazwaKierunku) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        WykladanyPrzedmiot wp = new WykladanyPrzedmiot();

        try {
            Wykladowca w = (Wykladowca) session.createSQLQuery("select * from wykladowcy where pesel=\'" + peselWykladowcy + "\'").addEntity(Wykladowca.class).getSingleResult();
            Przedmiot p = (Przedmiot) session.createSQLQuery("select * from przedmioty where upper(nazwa)=upper(\'" + nazwaPrzedmiotu + "\')").addEntity(Przedmiot.class).getSingleResult();
            Kierunek k = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).getSingleResult();

            wp.setIdKierunku(k);
            wp.setIdPrzedmiotu(p);
            wp.setIdWykladowcy(w);

            session.save(wp);
        } catch (NoResultException e) {
            alert.setContentText("Nie ma takiego wykładowcy.");
            alert.showAndWait();
        }

        session.getTransaction().commit();
        session.close();

        return wp;
    }

     /**
     * Aktualizuje wykładany przedmiot w bazie danych. 
     *
     * @param peselWykladowcy
     * @param nazwaKierunku
     * @param nazwaPrzedmiotu
     * @param idWP
     */
    @Override
    public void updateWykladanyPrzedmiot(String peselWykladowcy, String nazwaKierunku, String nazwaPrzedmiotu, String idWP) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        WykladanyPrzedmiot wp = (WykladanyPrzedmiot) session.createSQLQuery("select * from wykladaneprzedmioty where idWykladanePrzedmioty=\'" + idWP + "\'").addEntity(WykladanyPrzedmiot.class).getSingleResult();

        Wykladowca w = (Wykladowca) session.createSQLQuery("select * from wykladowcy where pesel=\'" + peselWykladowcy + "\'").addEntity(Wykladowca.class).getSingleResult();
        Przedmiot p = (Przedmiot) session.createSQLQuery("select * from przedmioty where upper(nazwa)=upper(\'" + nazwaPrzedmiotu + "\')").addEntity(Przedmiot.class).getSingleResult();
        Kierunek k = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).getSingleResult();

        Wykladowca w2 = (Wykladowca) session.createSQLQuery("select * from wykladowcy where idWykladowcy=\'" + w.getIdWykladowcy() + "\'").addEntity(Wykladowca.class).getSingleResult();
        Przedmiot p2 = (Przedmiot) session.createSQLQuery("select * from przedmioty where idPrzedmiotu=\'" + p.getIdPrzedmiotu() + "\'").addEntity(Przedmiot.class).getSingleResult();
        Kierunek k2 = (Kierunek) session.createSQLQuery("select * from kierunki where idKierunku=\'" + k.getIdKierunku() + "\'").addEntity(Kierunek.class).getSingleResult();

        wp.setIdKierunku(k2);
        wp.setIdPrzedmiotu(p2);
        wp.setIdWykladowcy(w2);

        session.update(wp);

        session.getTransaction().commit();
        session.close();
    }

     /**
     * Usuwa wykładnay przedmiot z bazy danych. 
     *
     * @param wp
     * @return true/false
     */
    @Override
    public boolean deleteWykladanyPrzedmiot(WykladanyPrzedmiot wp) {
        session = sessionFactory.openSession();
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.flush();

            session.delete(wp);

            transaction.commit();
            result = true;
        } catch (PersistenceException e) {
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
     * Pobiera z bazy danych wykładane przedmioty według peselu wykładowcy.
     *
     * @param peselWykladowcy
     * @return lista wykładanych przedmiotów
     */
    @Override
    public List<WykladanyPrzedmiot> wyszukajWgPeselu(String peselWykladowcy) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Wykladowca w = (Wykladowca) session.createSQLQuery("select * from wykladowcy where pesel=\'" + peselWykladowcy + "\'").addEntity(Wykladowca.class).getSingleResult();

        List<WykladanyPrzedmiot> wp = session.createSQLQuery("select * from wykladaneprzedmioty where idWykladowcy=\'" + w.getIdWykladowcy() + "\'").addEntity(WykladanyPrzedmiot.class).list();

        session.getTransaction().commit();
        session.close();

        return wp;
    }

}
