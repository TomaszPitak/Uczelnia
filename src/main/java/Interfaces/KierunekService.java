 
package Interfaces;

import Entities.Kierunek;
import java.util.ArrayList;
import java.util.List;

public interface KierunekService {
   /*List<Kierunek>*/Kierunek wyszukajWgNazwy(String nazwa);
   Kierunek saveKierunek(String nazwa, String idKolegium);       
   void updateKierunek(String nazwa, String nazwaKolegium, String idKierunku);
   boolean deleteKierunek(Kierunek kierunek);
   ArrayList<String> pobierzKierunki(String nazwaKolegium);
   ArrayList<String> pobierzKierunki2();
   boolean wyszukajKierunek(String nazwa);
 //  Kierunek wyszukajWgId(String id);
}
