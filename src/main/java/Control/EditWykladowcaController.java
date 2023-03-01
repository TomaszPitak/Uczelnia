package Control;

import Entities.Wykladowca;
import DatabaseQueries.WykladowcaMethods;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * Kontroler okna edycji wykladowcy.
 *
 * @author Tomasz Pitak
 */
public class EditWykladowcaController implements Initializable {

    @FXML
    private TextField editWykladowcaImie;

    @FXML
    private TextField editWykladowcaNazwisko;

    @FXML
    private TextField editWykladowcaPesel;

    @FXML
    private TextField editWykladowcaMiasto;

    @FXML
    private TextField editWykladowcaUlica;

    @FXML
    private TextField editWykladowcaMieszkanie;

    @FXML
    private TextField editWykladowcaTelefon;

    @FXML
    private TextField editWykladowcaEmail;

    @FXML
    private TextField editWykladowcaPensja;

    @FXML
    private TextField editWykladowcaStopien;

    public static Wykladowca wykladowca;
    public static int row;
    public static String kryterium;
    public static String wartosc;
    public WykladowcaMethods wykladowcaMethods;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wykladowcaMethods = new WykladowcaMethods();

        editWykladowcaImie.setText(wykladowca.getImie());
        editWykladowcaNazwisko.setText(wykladowca.getNazwisko());
        editWykladowcaPesel.setText(wykladowca.getPesel());
        editWykladowcaMiasto.setText(wykladowca.getMiasto());
        editWykladowcaUlica.setText(wykladowca.getUlica());
        editWykladowcaMieszkanie.setText(wykladowca.getNumerMieszkania());
        editWykladowcaTelefon.setText(wykladowca.getNumerTelefonu());
        editWykladowcaEmail.setText(wykladowca.getEmail());
        editWykladowcaPensja.setText(String.valueOf(wykladowca.getPensja()));
        editWykladowcaStopien.setText(wykladowca.getStopien());
    }

    /**
     * Wywołuje metodę aktualizacji danego wykładowcy. 
     *
     * @param actionEvent
     */
    @FXML
    public void btnZapiszEditWykladowca(ActionEvent actionEvent) {

        int error = 0;
        int i = 0;

        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");

        if (editWykladowcaImie.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz imię.");
            alert.showAndWait();
        } else {
            String imie = editWykladowcaImie.getText();
            char[] charsImie = imie.toCharArray();
            for (char c : charsImie) {
                if (Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Imię zawiera cyfry.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaNazwisko.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz nazwisko.");
            alert.showAndWait();
        } else {
            i = 0;
            String nazwisko = editWykladowcaNazwisko.getText();
            char[] charsNazwisko = nazwisko.toCharArray();
            for (char c : charsNazwisko) {
                if (Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Nazwisko zawiera cyfry.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaPesel.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz pesel.");
            alert.showAndWait();
        } else if (editWykladowcaPesel.getText().length() != 11) {
            error++;
            alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
            alert.showAndWait();
        } else {
            i = 0;
            String pesel = editWykladowcaPesel.getText();
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

        if (editWykladowcaTelefon.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz numer telefonu.");
            alert.showAndWait();
        } else if (editWykladowcaTelefon.getText().length() != 9) {
            error++;
            alert.setContentText("Numer telefonu nie zawiera 9 cyfr.");
            alert.showAndWait();
        } else {
            i = 0;
            String nrTel = editWykladowcaTelefon.getText();
            char[] charsTel = nrTel.toCharArray();
            for (char c : charsTel) {
                if (!Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Numer telefonu zawiera litery.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaEmail.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz e-mail.");
            alert.showAndWait();
        } else {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);

            if (!pattern.matcher(editWykladowcaEmail.getText()).matches()) {
                error++;
                alert.setContentText("Zły format email.");
                alert.showAndWait();
            }
        }

        if (editWykladowcaMiasto.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz miejscowosc.");
            alert.showAndWait();
        } else {
            i = 0;
            String miejscowosc = editWykladowcaMiasto.getText();
            char[] charsMiejscowosc = miejscowosc.toCharArray();
            for (char c : charsMiejscowosc) {
                if (Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Miejscowość zawiera cyfry.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaUlica.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz ulicę.");
            alert.showAndWait();
        } else {
            i = 0;
            String ulica = editWykladowcaUlica.getText();
            char[] charsUlica = ulica.toCharArray();
            for (char c : charsUlica) {
                if (Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Ulica zawiera cyfry.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaMieszkanie.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz mieszkanie.");
            alert.showAndWait();
        } else {
            i = 0;
            String nrMieszkania = editWykladowcaMieszkanie.getText();
            char[] charsMieszkanie = nrMieszkania.toCharArray();
            for (char c : charsMieszkanie) {
                if (!Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Numer mieszkania zawiera litery.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaPensja.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz pensję.");
            alert.showAndWait();
        } else {
            i = 0;
            String pensja = editWykladowcaPensja.getText();
            char[] charsPensja = pensja.toCharArray();
            for (char c : charsPensja) {
                if (!Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Pensja zawiera litery.");
                    alert.showAndWait();
                }
            }
        }

        if (editWykladowcaStopien.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz stopień.");
            alert.showAndWait();
        } else {
            i = 0;
            String stopien = editWykladowcaStopien.getText();
            char[] charsStopien = stopien.toCharArray();
            for (char c : charsStopien) {
                if (Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Stopien zawiera cyfry.");
                    alert.showAndWait();
                }
            }

            if (error == 0) {
                wykladowcaMethods.updateWykladowca(editWykladowcaImie.getText(), editWykladowcaNazwisko.getText(), editWykladowcaPesel.getText(), editWykladowcaMiasto.getText(), editWykladowcaUlica.getText(), editWykladowcaMieszkanie.getText(), editWykladowcaPensja.getText(), editWykladowcaTelefon.getText(), editWykladowcaEmail.getText(), editWykladowcaStopien.getText(), String.valueOf(wykladowca.getIdWykladowcy()));

                if (kryterium.equals("PESEL")) {
                    List<Wykladowca> array = wykladowcaMethods.wyszukajWgPeselu(wartosc);
                    MainController.wykladowcy.setAll(array);
                } else if (kryterium.equals("nazwisko")) {
                    List<Wykladowca> array = wykladowcaMethods.wyszukajWgNazwiska(wartosc);
                    MainController.wykladowcy.setAll(array);
                }

                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Pomyślnie edytowano.");
                alert.showAndWait();
            }
        }
    }
}
