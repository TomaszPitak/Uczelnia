package DatabaseQueries;

import Entities.Przedmiot;
import Entities.Kierunek;
import Interfaces.PrzedmiotService;
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
 * Zawiera metody dla tabeli przedmioty.
 *
 * @author Tomasz Pitak
 */
public class PrzedmiotMethods implements PrzedmiotService {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public PrzedmiotMethods() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Pobiera z bazy danych przedmioty według nazwy.
     *
     * @param nazwa nazwa przedmiotu
     * @return lista przedmiotów
     */
    @Override
    public List<Przedmiot> wyszukajWgNazwy(String nazwa) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Przedmiot> p = session.createSQLQuery("select * from przedmioty where upper(nazwa)=upper(\'" + nazwa + "\')").addEntity(Przedmiot.class).list();

        session.getTransaction().commit();
        session.close();

        return p;
    }

    /**
     * Zapisuje przedmiot do bazy danych.
     *
     * @param nazwa
     * @param nazwaKierunku
     * @return dodany przedmiot
     */
    @Override
    public Przedmiot savePrzedmiot(String nazwa, String nazwaKierunku) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kierunek k = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).getSingleResult();
        Przedmiot p = new Przedmiot(k, nazwa);

        session.save(p);

        session.getTransaction().commit();
        session.close();

        return p;
    }

    /**
     * Aktualizuje przedmiot w bazie danych. 
     *
     * @param nazwa
     * @param nazwaKierunku
     * @param idPrzedmiotu
     */
    @Override
    public void updatePrzedmiot(String nazwa, String nazwaKierunku, String idPrzedmiotu) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Przedmiot przedmiot = (Przedmiot) session.createSQLQuery("select * from przedmioty where idPrzedmiotu=\'" + idPrzedmiotu + "\'").addEntity(Przedmiot.class).getSingleResult();
        Kierunek kierunek = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).getSingleResult();

        //aktualizacja parametrów przedmiotu
        przedmiot.setNazwa(nazwa);
        przedmiot.setIdKierunku(kierunek);

        //update obiektu przedmiot
        session.update(przedmiot);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Usuwa przedmiot z bazy danych. 
     *
     * @param przedmiot
     * @return true - jeśli pomyślnie usunięto;
     *         false - jeśli wystąpiły błędy
     */
    @Override
    public boolean deletePrzedmiot(Przedmiot przedmiot) {
        session = sessionFactory.openSession();
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.flush();

            session.delete(przedmiot);

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
     * Sprawdza czy w bazie istanieje przedmiot o danej nazwie.
     *
     * @param nazwa 
     * @return true/false
     */
    @Override
    public boolean wyszukajPrzedmiot(String nazwa) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.flush();
            Przedmiot p = (Przedmiot) session.createSQLQuery("select * from przedmioty where upper(nazwa)=upper(\'" + nazwa + "\')").addEntity(Przedmiot.class).getSingleResult();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    /**
     * Pobiera nazwy przedmiotów z bazy danych według nazwy kierunku.
     *
     * @param nazwaKierunku 
     * @return lista nazw przedmiotów
     */
    @Override
    public ArrayList<String> pobierzPrzedmioty(String nazwaKierunku) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kierunek k = (Kierunek) session.createSQLQuery("select * from kierunki where upper(nazwa)=upper(\'" + nazwaKierunku + "\')").addEntity(Kierunek.class).uniqueResult();

        List<Przedmiot> lista = session.createSQLQuery("select * from przedmioty where idKierunku=\'" + k.getIdKierunku() + "\'").addEntity(Przedmiot.class).list();
        ArrayList<String> przedmioty = new ArrayList<>();
        //pobranie samych nazw
        for (int i = 0; i < lista.size(); i++) {
            przedmioty.add(lista.get(i).getNazwa());
        }

        session.getTransaction().commit();
        session.close();

        return przedmioty;
    }

}
