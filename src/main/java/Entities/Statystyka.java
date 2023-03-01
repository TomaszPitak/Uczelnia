package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'statystyki' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "statystyki")
public class Statystyka implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "STATYSTYKI_SEQ", allocationSize = 1)
    @Column(name = "numer", nullable = false)
    private int numer;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;
    
    @Column(name = "wartosc", nullable = false)
    private int wartosc;
    
    @Column(name = "data", nullable = false)
    private String z_data;

    public Statystyka(int numer, String nazwa, int wartosc, String data) {
        this.numer = numer;
        this.nazwa = nazwa;
        this.wartosc = wartosc;
        this.z_data = data;
    }

    public Statystyka(int numer, String nazwa, int wartosc) {
        this.numer = numer;
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    public Statystyka() {
    }

    public int getNumer() {
        return numer;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getWartosc() {
        return wartosc;
    }

    public String getData() {
        return z_data;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public void setData(String data) {
        this.z_data = data;
    }

    @Override
    public String toString() {
        return "Statystyka{" + "numer=" + numer + ", nazwa=" + nazwa + ", wartosc=" + wartosc + ", data=" + z_data + '}';
    }
 
}
