package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'kolegia' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "kolegia")
public class Kolegium implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "KOLEGIA_SEQ", allocationSize = 1)
    @Column(name = "idKolegium", nullable = false)
    private int idKolegium;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    @Column(name = "miasto", nullable = false)
    private String miasto;

    @Column(name = "ulica", nullable = false)
    private String ulica;

    @Column(name = "nrBudynku", nullable = false)
    private String nrBudynku;

    @Column(name = "kodPocztowy", nullable = false)
    private String kodPocztowy;

    public Kolegium(String nazwa, String miasto, String ulica, String nrBudynku, String kodPocztowy) {
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrBudynku = nrBudynku;
        this.kodPocztowy = kodPocztowy;
    }

    public Kolegium() {
    }

    public int getIdKolegium() {
        return idKolegium;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNrBudynku() {
        return nrBudynku;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setIdKolegium(int idKolegium) {
        this.idKolegium = idKolegium;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setNrBudynku(String nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return "Kolegium{" + "idKolegium=" + idKolegium + ", nazwa=" + nazwa + ", miasto=" + miasto + ", ulica=" + ulica + ", nrBudynku=" + nrBudynku + ", kodPocztowy=" + kodPocztowy + '}';
    }

}
