package Control;

import Entities.Kierunek;
import DatabaseQueries.KolegiumMethods;
import DatabaseQueries.KierunekMethods;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Kontroler okna edycji kierunku.
 *
 * @author Tomasz Pitak
 */
public class EditKierunekController implements Initializable {

    @FXML
    private TextField editKierunekNazwa;

    @FXML
    private ComboBox<String> comboEditKierunekKolegium;

    public static Kierunek kierunek;
    public static int row;
    public static String kryterium;
    public static String wartosc;
    public KolegiumMethods kolegiumMethods;
    public KierunekMethods kierunekMethods;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kolegiumMethods = new KolegiumMethods();
        kierunekMethods = new KierunekMethods();

        editKierunekNazwa.setText(kierunek.getNazwa());
        comboEditKierunekKolegium.getItems().addAll(kolegiumMethods.pobierzKolegia());
        
        comboEditKierunekKolegium.getSelectionModel().select(kierunek.getIdKolegium().getNazwa());
    }

    /**
     * Wywołuje metodę aktualizacji danego kierunku. 
     *
     * @param actionEvent
     */
    @FXML
    public void btnZapiszEditKierunek(ActionEvent actionEvent) {

        int error = 0;
        int i = 0;

        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        if (editKierunekNazwa.getText().equals("")) {
            alert.setContentText("Wpisz nazwę.");
            alert.showAndWait();
        } else {
            i = 0;
            String nazwa = editKierunekNazwa.getText();
            char[] charsNazwa = nazwa.toCharArray();
            for (char c : charsNazwa) {
                if (Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Nazwa zawiera cyfry.");
                    alert.showAndWait();
                }
            }

            if (error == 0) {
                kierunekMethods.updateKierunek(editKierunekNazwa.getText(), comboEditKierunekKolegium.getValue(), String.valueOf(kierunek.getIdKierunku()));

                MainController.kierunki.setAll(kierunekMethods.wyszukajWgNazwy(wartosc));

                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Pomyślnie edytowano.");
                alert.showAndWait();
            }
        }
    }
}
