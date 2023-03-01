package Control;

import Entities.WykladanyPrzedmiot;
import DatabaseQueries.*;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.persistence.NoResultException;

/**
 * Kontroler okna edycji wykładanego przedmiotu.
 *
 * @author Tomasz Pitak
 */
public class EditWykladanyPrzedmiotController implements Initializable {

    @FXML
    private TextField editWPpesel;

    @FXML
    private ComboBox<String> comboEditWPkierunek;

    @FXML
    private ComboBox<String> comboEditWPprzedmiot;

    public static WykladanyPrzedmiot wykladanyPrzedmiot;
    public static int row;
    public static String kryterium;
    public static String wartosc;
    public PrzedmiotMethods przedmiotMethods;
    public KierunekMethods kierunekMethods;
    public WykladanyPrzedmiotMethods wykladanyPrzedmiotMethods;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        przedmiotMethods = new PrzedmiotMethods();
        kierunekMethods = new KierunekMethods();
        wykladanyPrzedmiotMethods = new WykladanyPrzedmiotMethods();

        editWPpesel.setText(wykladanyPrzedmiot.getIdWykladowcy().getPesel());

        comboEditWPkierunek.getItems().addAll(kierunekMethods.pobierzKierunki2());
        comboEditWPkierunek.getSelectionModel().select(wykladanyPrzedmiot.getIdKierunku().getNazwa());

        comboEditWPprzedmiot.getItems().addAll(przedmiotMethods.pobierzPrzedmioty(comboEditWPkierunek.getValue()));
        comboEditWPprzedmiot.getSelectionModel().select(wykladanyPrzedmiot.getIdPrzedmiotu().getNazwa());

        comboEditWPkierunek.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldvalue, String newvalue) {//zmiana itemu
                comboEditWPprzedmiot.getItems().clear();//wyczyszczenie listy
                comboEditWPprzedmiot.getItems().addAll(przedmiotMethods.pobierzPrzedmioty(comboEditWPkierunek.getValue()));
                comboEditWPprzedmiot.getSelectionModel().selectFirst();
            }
        });
    }

    /**
     * Wywołuje metodę aktualizacji wykładanego przedmiotu. 
     *
     * @param actionEvent
     */
    @FXML
    public void btnZapiszEditWP(ActionEvent actionEvent) {

        int error = 0;
        int i = 0;

        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        if (editWPpesel.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz pesel.");
            alert.showAndWait();
        } else if (editWPpesel.getText().length() != 11) {
            error++;
            alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
            alert.showAndWait();
        } else {
            i = 0;
            String pesel = editWPpesel.getText();
            char[] charsPesel = pesel.toCharArray();
            for (char c : charsPesel) {
                if (!Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Pesel zawiera litery.");
                    alert.showAndWait();
                }
            }
        }

        if (error == 0) {
            try {
                wykladanyPrzedmiotMethods.updateWykladanyPrzedmiot(editWPpesel.getText(), comboEditWPkierunek.getValue(), comboEditWPprzedmiot.getValue(), String.valueOf(wykladanyPrzedmiot.getIdWykladanePrzedmioty()));

                if (kryterium.equals("PESEL")) {
                    MainController.wykladanePrzedmioty.setAll(wykladanyPrzedmiotMethods.wyszukajWgPeselu(wartosc));
                }

                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Pomyślnie edytowano.");
                alert.showAndWait();

            } catch (NoResultException e) {
                alert.setContentText("Nie istnieje wykładowca o podanym peselu.");
                alert.showAndWait();

            }
        }
    }
}