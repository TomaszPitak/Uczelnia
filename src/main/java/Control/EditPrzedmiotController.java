package Control;

import Entities.Przedmiot;
import DatabaseQueries.PrzedmiotMethods;
import DatabaseQueries.KierunekMethods;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Kontroler okna edycji przedmiotu.
 *
 * @author Tomasz Pitak
 */
public class EditPrzedmiotController implements Initializable {

    @FXML
    private TextField editPrzedmiotNazwa;

    @FXML
    private ComboBox<String> comboEditPrzedmiotKierunek;

    public static Przedmiot przedmiot;
    public static int row;
    public static String kryterium;
    public static String wartosc;
    public PrzedmiotMethods przedmiotMethods;
    public KierunekMethods kierunekMethods;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        przedmiotMethods = new PrzedmiotMethods();
        kierunekMethods = new KierunekMethods();

        editPrzedmiotNazwa.setText(przedmiot.getNazwa());
        comboEditPrzedmiotKierunek.getItems().addAll(kierunekMethods.pobierzKierunki2());
        comboEditPrzedmiotKierunek.getSelectionModel().select(przedmiot.getIdKierunku().getNazwa());
    }

    /**
     * Wywołuje metodę aktualizacji danego przedmiotu. 
     *
     * @param actionEvent
     */
    @FXML
    public void btnZapiszEditPrzedmiot(ActionEvent actionEvent) {

        int error = 0;
        int i = 0;

        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        if (editPrzedmiotNazwa.getText().equals("")) {
            alert.setContentText("Wpisz nazwę.");
            alert.showAndWait();
        } else {
            i = 0;
            String nazwa = editPrzedmiotNazwa.getText();
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
                przedmiotMethods.updatePrzedmiot(editPrzedmiotNazwa.getText(), comboEditPrzedmiotKierunek.getValue(), String.valueOf(przedmiot.getIdPrzedmiotu()));

                MainController.przedmioty.setAll(przedmiotMethods.wyszukajWgNazwy(wartosc));

                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Pomyślnie edytowano.");
                alert.showAndWait();
            }
        }
    }
}
