package Control;

import DatabaseQueries.KierunekMethods;
import DatabaseQueries.KolegiumMethods;
import Entities.Student;
import DatabaseQueries.StudentMethods;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Kontroler okna edycji studenta.
 *
 * @author Tomasz Pitak
 */
public class EditStudentController implements Initializable {

    @FXML
    private TextField editStudentImie;

    @FXML
    private TextField editStudentNazwisko;

    @FXML
    private TextField editStudentPesel;

    @FXML
    private TextField editStudentMiasto;

    @FXML
    private TextField editStudentUlica;

    @FXML
    private TextField editStudentMieszkanie;

    @FXML
    private TextField editStudentTelefon;

    @FXML
    private TextField editStudentEmail;

    @FXML
    private TextField editStudentSemestr;

    @FXML
    private TextField editStudentAlbum;

    @FXML
    private ComboBox<String> comboEditStudentKolegium;

    @FXML
    private ComboBox<String> comboEditStudentKierunek;

    public static Student student;
    public static int row;
    public static String kryterium;
    public static String wartosc;
    public StudentMethods studentMethods;
    public KolegiumMethods kolegiumMethods;
    public KierunekMethods kierunekMethods;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentMethods = new StudentMethods();
        kolegiumMethods = new KolegiumMethods();
        kierunekMethods = new KierunekMethods();

        editStudentImie.setText(student.getImie());
        editStudentNazwisko.setText(student.getNazwisko());
        editStudentPesel.setText(student.getPesel());
        editStudentMiasto.setText(student.getMiasto());
        editStudentUlica.setText(student.getUlica());
        editStudentMieszkanie.setText(student.getNrMieszkania());
        editStudentTelefon.setText(student.getNrTelefonu());
        editStudentEmail.setText(student.getEmail());
        editStudentSemestr.setText(student.getNrSemestru());
        editStudentAlbum.setText(student.getNrAlbumu());

        comboEditStudentKolegium.getItems().addAll(kolegiumMethods.pobierzKolegia());
        comboEditStudentKolegium.getSelectionModel().select(student.getIdKolegium().getNazwa());
        comboEditStudentKierunek.getItems().addAll(kierunekMethods.pobierzKierunki(comboEditStudentKolegium.getValue()));
        comboEditStudentKierunek.getSelectionModel().select(student.getIdKierunku().getNazwa());
        
        comboEditStudentKolegium.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldvalue, String newvalue) {//zmiana itemu
                comboEditStudentKierunek.getItems().clear();//wyczyszczenie listy
                comboEditStudentKierunek.getItems().addAll(kierunekMethods.pobierzKierunki(comboEditStudentKolegium.getValue()));
                comboEditStudentKierunek.getSelectionModel().selectFirst();
            }
        });
    }

    /**
     * Wywołuje metodę aktualizacji danego studenta. 
     *
     * @param actionEvent
     */
    @FXML
    public void btnZapiszEditStudent(ActionEvent actionEvent) {
        int error = 0;
        int i = 0;

        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");

        if (editStudentImie.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz imię.");
            alert.showAndWait();
        } else {
            String imie = editStudentImie.getText();
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

        if (editStudentNazwisko.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz nazwisko.");
            alert.showAndWait();
        } else {
            i = 0;
            String nazwisko = editStudentNazwisko.getText();
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

        if (editStudentPesel.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz pesel.");
            alert.showAndWait();
        } else if (editStudentPesel.getText().length() != 11) {
            error++;
            alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
            alert.showAndWait();
        } else {
            i = 0;
            String pesel = editStudentPesel.getText();
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

        if (editStudentTelefon.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz numer telefonu.");
            alert.showAndWait();
        } else if (editStudentTelefon.getText().length() != 9) {
            error++;
            alert.setContentText("Numer telefonu nie zawiera 9 cyfr.");
            alert.showAndWait();
        } else {
            i = 0;
            String nrTel = editStudentTelefon.getText();
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

        if (editStudentEmail.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz e-mail.");
            alert.showAndWait();
        } else {
            //Regular Expression   
            String regex = "^(.+)@(.+)$";
            //Compile regular expression to get the pattern  
            Pattern pattern = Pattern.compile(regex);

            if (!pattern.matcher(editStudentEmail.getText()).matches()) {
                error++;
                alert.setContentText("Zły format email.");
                alert.showAndWait();
            }
        }

        if (editStudentMiasto.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz miejscowosc.");
            alert.showAndWait();
        } else {
            i = 0;
            String miejscowosc = editStudentMiasto.getText();
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

        if (editStudentUlica.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz ulicę.");
            alert.showAndWait();
        } else {
            i = 0;
            String ulica = editStudentUlica.getText();
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

        if (editStudentMieszkanie.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz mieszkanie.");
            alert.showAndWait();
        } else {
            i = 0;
            String nrMieszkania = editStudentMieszkanie.getText();
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

        if (editStudentAlbum.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz numer albumu.");
            alert.showAndWait();
        } else if (editStudentAlbum.getText().length() != 6) {
            error++;
            alert.setContentText("Numer albumu nie zawiera 6 cyfr.");
            alert.showAndWait();
        } else {
            i = 0;
            String album = editStudentAlbum.getText();
            char[] charsAlbum = album.toCharArray();
            for (char c : charsAlbum) {
                if (!Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Numer albumu zawiera litery.");
                    alert.showAndWait();
                }
            }
        }

        if (editStudentSemestr.getText().equals("")) {
            error++;
            alert.setContentText("Wpisz numer semestru.");
            alert.showAndWait();
        } else {
            i = 0;
            String semestr = editStudentSemestr.getText();
            char[] charsSemestr = semestr.toCharArray();
            for (char c : charsSemestr) {
                if (!Character.isDigit(c) && i == 0) {
                    i++;
                    error++;
                    alert.setContentText("Numer semestru zawiera litery.");
                    alert.showAndWait();
                }
            }
        }

        if (error == 0) {
            studentMethods.updateStudent(comboEditStudentKierunek.getValue(), comboEditStudentKolegium.getValue(), editStudentImie.getText(), editStudentNazwisko.getText(), editStudentPesel.getText(), editStudentMiasto.getText(), editStudentUlica.getText(), editStudentMieszkanie.getText(), editStudentTelefon.getText(), editStudentEmail.getText(), editStudentSemestr.getText(), editStudentAlbum.getText(), String.valueOf(student.getIdStudenta()));

            if (kryterium.equals("PESEL")) {
                MainController.studenci.setAll(studentMethods.wyszukajWgPeselu(wartosc));
            } else if (kryterium.equals("nazwisko")) {
                MainController.studenci.setAll(studentMethods.wyszukajWgNazwiska(wartosc));
            }

            alert.setTitle("Info");
            alert.setHeaderText("Info");
            alert.setContentText("Pomyślnie edytowano.");
            alert.showAndWait();
        }
    }
}
