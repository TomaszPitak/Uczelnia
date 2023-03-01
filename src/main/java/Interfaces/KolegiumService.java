
package Interfaces;

import Entities.Kolegium;
import java.util.ArrayList;

public interface KolegiumService {
   ArrayList<String> pobierzKolegia();
   Kolegium wyszukajWgNazwy(String nazwa);
}
