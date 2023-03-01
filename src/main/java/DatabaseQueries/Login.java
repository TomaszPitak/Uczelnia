package DatabaseQueries;

import Control.MainController;
import Entities.User;
import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javafx.scene.control.Alert;

/**
 * Zawiera metody do obsługi logowania.
 *
 * @author Tomasz Pitak
 */
public class Login {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private SessionFactory sessionFactory;
    private Session session;

    public Login() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
     * Loguje użytkownika.
     *
     * @param login 
     * @param haslo
     * @return true/false
     */
    public boolean zaloguj(String login, String haslo) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.flush();
        session.clear();

        String check = (String) session.createSQLQuery("select Login(\'" + login + "\',\'" + haslo + "\') from dual").getSingleResult();
        System.out.println(check);
        if (Boolean.parseBoolean(check)) {
            User user = (User) session.createSQLQuery("select * from users where login=\'" + login + "\'").addEntity(User.class).getSingleResult();
            MainController.user = user;
            session.getTransaction().commit();
            session.close();
            return true;
        } else {
            session.getTransaction().commit();
            session.close();
            alert.setContentText("Niepoprawne dane.");
            alert.showAndWait();
            return false;
        }

    }

}
