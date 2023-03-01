package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'kierunki' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "kierunki")
public class Kierunek implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "KIERUNKI_SEQ", allocationSize = 1)
    @Column(name = "idKierunku", nullable = false)
    private int idKierunku;

    @ManyToOne(targetEntity = Kolegium.class)
    @JoinColumn(name = "idKolegium", nullable = false)
    private Kolegium idKolegium;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    public Kierunek(Kolegium idKolegium, String nazwa) {
        this.idKolegium = idKolegium;
        this.nazwa = nazwa;
    }

    public Kierunek() {
    }

    public int getIdKierunku() {
        return idKierunku;
    }

    public Kolegium getIdKolegium() {
        return idKolegium;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setIdKolegium(Kolegium idKolegium) {
        this.idKolegium = idKolegium;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setIdKierunku(int idKierunku) {
        this.idKierunku = idKierunku;
    }

    @Override
    public String toString() {
        return "Kierunek{" + "idKierunku=" + idKierunku + ", idKolegium=" + idKolegium + ", nazwa=" + nazwa + '}';
    }

}
