package DatabaseQueries;

import Entities.Kolegium;
import Interfaces.KolegiumService;
import Singleton.SingletonConnection;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Zawiera metody dla tabeli kolegia.
 *
 * @author Tomasz Pitak
 */
public class KolegiumMethods implements KolegiumService {

    private SessionFactory sessionFactory;
    private Session session;

    public KolegiumMethods() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Pobiera wszystkie nazwy kolegiów z bazy danych.
     *
     * @return kolegia lista nazw kolegiów
     */
    @Override
    public ArrayList<String> pobierzKolegia() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Kolegium> lista = session.createSQLQuery("select * from kolegia").addEntity(Kolegium.class).list();
        ArrayList<String> kolegia = new ArrayList<>();
        //pobranie samych nazw
        for (int i = 0; i < lista.size(); i++) {
            kolegia.add(lista.get(i).getNazwa());
        }

        session.getTransaction().commit();
        session.close();

        return kolegia;
    }

    /**
     * Pobiera z bazy danych kolegia według nazwy.
     *
     * @param nazwa nazwa kolegium
     * @return kolegium
     */
    @Override
    public Kolegium wyszukajWgNazwy(String nazwa) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        Kolegium k = (Kolegium) session.createSQLQuery("select * from kolegia where nazwa=\'" + nazwa + "\'").addEntity(Kolegium.class).uniqueResult();

        session.getTransaction().commit();
        session.close();

        return k;
    }

}
