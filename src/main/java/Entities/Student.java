package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'studenci' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "studenci")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "STUDENCI_SEQ", allocationSize = 1)
    @Column(name = "idStudenta", nullable = false)
    private int idStudenta;

    @ManyToOne(targetEntity = Kierunek.class)
    @JoinColumn(name = "idKierunku", nullable = false)
    private Kierunek idKierunku;

    @ManyToOne(targetEntity = Kolegium.class)
    @JoinColumn(name = "idKolegium", nullable = false)
    private Kolegium idKolegium;

    @Column(name = "imie", nullable = false)
    private String imie;

    @Column(name = "nazwisko", nullable = false)
    private String nazwisko;

    @Column(name = "pesel", nullable = false)
    private String pesel;

    @Column(name = "miasto", nullable = false)
    private String miasto;

    @Column(name = "ulica", nullable = false)
    private String ulica;

    @Column(name = "numerMieszkania", nullable = false)
    private String nrMieszkania;

    @Column(name = "numerTelefonu", nullable = false)
    private String nrTelefonu;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nrSemestru", nullable = false)
    private String nrSemestru;

    @Column(name = "nrAlbumu", nullable = false)
    private String nrAlbumu;

    public Student(Kierunek idKierunku, Kolegium idKolegium, String imie, String nazwisko, String pesel, String miasto, String ulica, String nrMieszkania, String nrTelefonu, String email, String nrSemestru, String nrAlbumu) {
        this.idKierunku = idKierunku;
        this.idKolegium = idKolegium;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrMieszkania = nrMieszkania;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.nrSemestru = nrSemestru;
        this.nrAlbumu = nrAlbumu;
    }

    public Student(int idStudenta, Kierunek idKierunku, Kolegium idKolegium, String imie, String nazwisko, String pesel, String miasto, String ulica, String nrMieszkania, String nrTelefonu, String email, String nrSemestru, String nrAlbumu) {
        this.idStudenta = idStudenta;
        this.idKierunku = idKierunku;
        this.idKolegium = idKolegium;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrMieszkania = nrMieszkania;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.nrSemestru = nrSemestru;
        this.nrAlbumu = nrAlbumu;
    }
    
    

    public Student() {
    }

    public int getIdStudenta() {
        return idStudenta;
    }

    public Kierunek getIdKierunku() {
        return idKierunku;
    }

    public Kolegium getIdKolegium() {
        return idKolegium;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNrMieszkania() {
        return nrMieszkania;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public String getNrSemestru() {
        return nrSemestru;
    }

    public String getNrAlbumu() {
        return nrAlbumu;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    public void setIdKierunku(Kierunek idKierunku) {
        this.idKierunku = idKierunku;
    }

    public void setIdKolegium(Kolegium idKolegium) {
        this.idKolegium = idKolegium;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setNrMieszkania(String nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrSemestru(String nrSemestru) {
        this.nrSemestru = nrSemestru;
    }

    public void setNrAlbumu(String nrAlbumu) {
        this.nrAlbumu = nrAlbumu;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudenta=" + idStudenta + ", idKierunku=" + idKierunku + ", idKolegium=" + idKolegium + ", imie=" + imie + ", nazwisko=" + nazwisko + ", pesel=" + pesel + ", miejscowosc=" + miasto + ", ulica=" + ulica + ", nrMieszkania=" + nrMieszkania + ", nrTelefonu=" + nrTelefonu + ", email=" + email + ", nrSemestru=" + nrSemestru + ", nrAlbumu=" + nrAlbumu + '}';
    }

    

}
