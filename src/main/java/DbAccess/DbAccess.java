package DbAccess;

import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Sprawdza połączenie z bazą danych
 *
 * @author Tomasz Pitak
 */
public class DbAccess {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static boolean CONNECTION;
    
    static {
        try {
            sessionFactory = SingletonConnection.getSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Pobiera nazwe bazy danych, z którą się łączy.
     *
     * @return name nazwa bazy danych, jeśi nawiązano połączenie
     */
    public String getDatabaseName() {
        String name;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            name = session.createSQLQuery("select ora_database_name from dual").getSingleResult().toString();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            CONNECTION = false;
            return "błąd połączenia";
        }
        CONNECTION = true;
        return name;
    }

}
