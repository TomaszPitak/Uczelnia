
package Interfaces;

import Entities.Wykladowca;
import java.util.List;

public interface WykladowcaService {
   List<Wykladowca> wyszukajWgPeselu(String pesel);
   List<Wykladowca> wyszukajWgNazwiska(String nazwisko);
   Wykladowca saveWykladowca(String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String pensja, String nrTelefonu, String email, String stopien);      
   void updateWykladowca(String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String pensja, String nrTelefonu, String email, String stopien, String idWykladowcy);
   void deleteWykladowca(Wykladowca wykladowca);
   boolean wyszukajWykladowce(String pesel);
}
