package DatabaseQueries;

import Entities.*;
import Interfaces.StatystykaService;
import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.sql.*;
import org.hibernate.internal.SessionImpl;

/**
 * Zawiera metody dla tabeli statystyki.
 *
 * @author Tomasz Pitak
 */
public class StatystykaMethods implements StatystykaService {

    private SessionFactory sessionFactory;
    private Session session;

    public StatystykaMethods() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Pobiera statystyki z bazy danych.
     *
     * @return lista statystyk
     */
    @Override
    public List<Statystyka> pobierzStatystyki() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        List<Statystyka> s = session.createSQLQuery("select * from statystyki").addEntity(Statystyka.class).list();

        session.getTransaction().commit();
        session.close();

        return s;
    }
    
    /**
     * Aktualizuje statystyki wywołując funkcję AKTUALIZUJSTATYSTYKI.
     */
    @Override
    public void aktualizuj() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();

        try {
            SessionImpl sessionImpl = (SessionImpl) session;
            Connection connection = sessionImpl.connection();

            CallableStatement cstmt = connection.prepareCall("{?=call AKTUALIZUJSTATYSTYKI()}");
            cstmt.registerOutParameter(1, Types.NUMERIC);
            cstmt.execute();
        }catch(Exception e){
                System.out.println(e);   
        }

        session.getTransaction().commit();
        session.close();
    }
    
    /**
     * Tworzy tabelę statystyk wywołując funkcję UTWORZSTATYSTYKI.
     */
    public void utworzTabele(){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();
        
        try {
            SessionImpl sessionImpl = (SessionImpl) session;
            Connection connection = sessionImpl.connection();

            CallableStatement cstmt = connection.prepareCall("{?=call UTWORZSTATYSTYKI()}");
            cstmt.registerOutParameter(1, Types.NUMERIC);
            cstmt.execute();
        }catch(Exception e){
                System.out.println(e);   
        }

        session.getTransaction().commit();
        session.close();
    }
        
    

}
