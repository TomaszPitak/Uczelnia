
package Interfaces;

import Entities.Przedmiot;
import java.util.ArrayList;
import java.util.List;

public interface PrzedmiotService {
   List<Przedmiot> wyszukajWgNazwy(String nazwa);
   Przedmiot savePrzedmiot(String nazwa, String idKierunku);  
   void updatePrzedmiot(String nazwa, String nazwaKierunku, String idPrzedmiotu);
   boolean deletePrzedmiot(Przedmiot przedmiot);
   boolean wyszukajPrzedmiot(String nazwa);
   ArrayList<String> pobierzPrzedmioty(String nazwaKierunku);
}
