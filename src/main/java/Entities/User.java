package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'users' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "USERS_SEQ", allocationSize = 1)
    @Column(name = "idUser", nullable = false)
    private int idUser;

    @Column(name = "login", nullable = false)
    private String login;
    
    @Column(name = "haslo", nullable = false)
    private String haslo;
    
    @Column(name = "rola", nullable = false)
    private String rola;

    public User(int idUser, String login, String haslo, String rola) {
        this.idUser = idUser;
        this.login = login;
        this.haslo = haslo;
        this.rola = rola;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getRola() {
        return rola;
    }
    
    

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", login=" + login + ", haslo=" + haslo + ", rola=" + rola + '}';
    }

    

}
