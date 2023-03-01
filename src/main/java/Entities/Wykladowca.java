package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'wykladowcy' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "wykladowcy")
public class Wykladowca implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "WYKLADOWCY_SEQ", allocationSize = 1)
    @Column(name = "idWykladowcy", nullable = false)
    private int idWykladowcy;

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

    @Column(name = "pensja", nullable = false)
    private int pensja;

    @Column(name = "stopien", nullable = false)
    private String stopien;

    public Wykladowca(String imie, String nazwisko, String pesel, String miasto, String ulica, String nrMieszkania, String nrTelefonu, String email, int pensja, String stopien) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrMieszkania = nrMieszkania;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.pensja = pensja;
        this.stopien = stopien;
    }

    public Wykladowca() {
    }

    public int getIdWykladowcy() {
        return idWykladowcy;
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

    public String getNumerMieszkania() {
        return nrMieszkania;
    }

    public String getNumerTelefonu() {
        return nrTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public int getPensja() {
        return pensja;
    }

    public String getStopien() {
        return stopien;
    }

    public void setIdWykladowcy(int idWykladowcy) {
        this.idWykladowcy = idWykladowcy;
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

    public void setNumerMieszkania(String numerMieszkania) {
        this.nrMieszkania = numerMieszkania;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.nrTelefonu = numerTelefonu;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public void setStopien(String stopien) {
        this.stopien = stopien;
    }

    @Override
    public String toString() {
        return "Wykladowca{" + "idStudenta=" + idWykladowcy + ", imie=" + imie + ", nazwisko=" + nazwisko + ", pesel=" + pesel + ", miasto=" + miasto + ", ulica=" + ulica + ", numerMieszkania=" + nrMieszkania + ", numerTelefonu=" + nrTelefonu + ", email=" + email + ", pensja=" + pensja + ", stopien=" + stopien + '}';
    }

   
}
