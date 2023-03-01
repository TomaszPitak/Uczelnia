 
package Interfaces;

import Entities.*;
import java.util.ArrayList;
import java.util.List;

public interface WykladanyPrzedmiotService {
   WykladanyPrzedmiot saveWykladanyPrzedmiot(String peselWykladowcy, String nazwaPrzedmiotu, String nazwaKierunku);
   void updateWykladanyPrzedmiot(String peselWykladowcy, String nazwaPrzedmiotu, String nazwaKierunku, String idWK);
   boolean deleteWykladanyPrzedmiot(WykladanyPrzedmiot wp);
   List<WykladanyPrzedmiot> wyszukajWgPeselu(String peselWykladowcy);
}
