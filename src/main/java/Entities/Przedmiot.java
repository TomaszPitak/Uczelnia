package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Reprezentuje tabelę 'przedmioty' w bazie danych. 
 * 
 * @author Tomasz Pitak
 */
@Entity
@Table(name = "przedmioty")
public class Przedmiot implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "PRZEDMIOTY_SEQ", allocationSize = 1)
    @Column(name = "idPrzedmiotu", nullable = false)
    private int idPrzedmiotu;

    @ManyToOne(targetEntity = Kierunek.class)
    @JoinColumn(name = "idKierunku", nullable = false)
    private Kierunek idKierunku;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    public Przedmiot(Kierunek idKierunku, String nazwa) {
        this.idKierunku = idKierunku;
        this.nazwa = nazwa;
    }
    
    public Przedmiot(){
    }

    public void setIdPrzedmiotu(int idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public void setIdKierunku(Kierunek idKierunku) {
        this.idKierunku = idKierunku;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public Kierunek getIdKierunku() {
        return idKierunku;
    }

    public String getNazwa() {
        return nazwa;
    }
     
    @Override
    public String toString() {
        return "Przedmiot{" + "idPrzedmiotu=" + idPrzedmiotu + ", idKierunku=" + idKierunku + ", nazwa=" + nazwa + '}';
    }

}
