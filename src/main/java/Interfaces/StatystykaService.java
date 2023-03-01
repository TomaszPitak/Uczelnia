 
package Interfaces;

import Entities.Kierunek;
import Entities.Statystyka;
import java.util.ArrayList;
import java.util.List;

public interface StatystykaService {
    List<Statystyka> pobierzStatystyki();
    void aktualizuj();
}
