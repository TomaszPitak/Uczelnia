package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'wykladany przedmiot' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "wykladanePrzedmioty")
public class WykladanyPrzedmiot implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "WYKLADANEPRZEDMIOTY_SEQ", allocationSize = 1)
    @Column(name = "idWykladanePrzedmioty", nullable = false)
    private int idWykladanePrzedmioty;

    @ManyToOne(targetEntity = Kierunek.class)
    @JoinColumn(name = "idKierunku", nullable = false)
    private Kierunek idKierunku;
    
    @ManyToOne(targetEntity = Przedmiot.class)
    @JoinColumn(name = "idPrzedmiotu", nullable = false)
    private Przedmiot idPrzedmiotu;

    @ManyToOne(targetEntity = Wykladowca.class)
    @JoinColumn(name = "idWykladowcy", nullable = false)
    private Wykladowca idWykladowcy;

    public WykladanyPrzedmiot(Kierunek idKierunku, Przedmiot idPrzedmiotu, Wykladowca idWykladowcy) {
        this.idKierunku = idKierunku;
        this.idPrzedmiotu = idPrzedmiotu;
        this.idWykladowcy = idWykladowcy;
    }


    public WykladanyPrzedmiot() {
    }

    public int getIdWykladanePrzedmioty() {
        return idWykladanePrzedmioty;
    }

    public Kierunek getIdKierunku() {
        return idKierunku;
    }

    public Przedmiot getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public Wykladowca getIdWykladowcy() {
        return idWykladowcy;
    }

    public void setIdWykladanePrzedmioty(int idWykladanePrzedmioty) {
        this.idWykladanePrzedmioty = idWykladanePrzedmioty;
    }

    public void setIdKierunku(Kierunek idKierunku) {
        this.idKierunku = idKierunku;
    }

    public void setIdPrzedmiotu(Przedmiot idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public void setIdWykladowcy(Wykladowca idWykladowcy) {
        this.idWykladowcy = idWykladowcy;
    }
   
    @Override
    public String toString() {
        return "WykladanyPrzedmiot{" + "idWykladanePrzedmioty=" + idWykladanePrzedmioty + ", idKierunku=" + idKierunku + ", idPrzedmiotu=" + idPrzedmiotu + ", idWykladowcy=" + idWykladowcy + '}';
    }
    
}
