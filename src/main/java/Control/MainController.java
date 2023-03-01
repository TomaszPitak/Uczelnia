package Control;

import Entities.*;
import DbAccess.DbAccess;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.w3c.dom.NodeList;
import javafx.scene.Scene;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Modality;
import java.util.regex.*;
import javafx.scene.layout.StackPane;
import DatabaseQueries.*;

/**
 * Kontroler głównego okna programu.
 *
 * @author Tomasz Pitak
 */
public class MainController implements Initializable {

    @FXML
    private ComboBox<String> comboWyszukajKierunek;

    @FXML
    private ComboBox<String> comboWyszukajPrzedmiot;

    @FXML
    private ComboBox<String> comboWyszukajStudenta;

    @FXML
    private ComboBox<String> comboWyszukajWykladowce;

    @FXML
    private TextField fieldWyszukajKierunek;

    @FXML
    private TextField fieldWyszukajPrzedmiot;

    @FXML
    private TextField fieldWyszukajStudenta;

    @FXML
    private TextField fieldWyszukajWykladowce;

    @FXML
    private Label labelZalogowano;

    @FXML
    private Label labelBaza;

    @FXML
    private Pane leftPane;

    @FXML
    private Pane paneTabelaKierunki;

    @FXML
    private Pane paneTabelaPrzedmioty;

    @FXML
    private Pane paneTabelaStudenci;

    @FXML
    private Pane paneTabelaWykladowcy;

    @FXML
    private Pane paneWyszukajKierunek;

    @FXML
    private Pane paneWyszukajPrzedmiot;

    @FXML
    private Pane paneWyszukajStudenta;

    @FXML
    private Pane paneWyszukajWykladowce;

    @FXML
    private Pane paneLogowanie;

    @FXML
    private StackPane stack;

    @FXML
    private TableColumn<Kierunek, Void> tabKierunkiBtnDelete;

    @FXML
    private TableColumn<Kierunek, Void> tabKierunkiBtnEdit;

    @FXML
    private TableColumn<Kierunek, String> tabKierunkiIdKierunku;

    @FXML
    private TableColumn<Kierunek, String> tabKierunkiIdKolegium;

    @FXML
    private TableColumn<Kierunek, String> tabKierunkiNazwa;

    @FXML
    private TableColumn<Przedmiot, Void> tabPrzedmiotyBtnDelete;

    @FXML
    private TableColumn<Przedmiot, Void> tabPrzedmiotyBtnEdit;

    @FXML
    private TableColumn<Przedmiot, String> tabPrzedmiotyIdKierunku;

    @FXML
    private TableColumn<Przedmiot, String> tabPrzedmiotyIdPrzedmiotu;

    @FXML
    private TableColumn<Przedmiot, String> tabPrzedmiotyNazwa;

    @FXML
    private TableColumn<Student, Void> tabStudenciBtnDelete;

    @FXML
    private TableColumn<Student, Void> tabStudenciBtnEdit;

    @FXML
    private TableColumn<Student, String> tabStudenciEmail;

    @FXML
    private TableColumn<Student, String> tabStudenciIdKierunku;

    @FXML
    private TableColumn<Student, String> tabStudenciIdKolegium;

    @FXML
    private TableColumn<Student, String> tabStudenciIdStudenta;

    @FXML
    private TableColumn<Student, String> tabStudenciImie;

    @FXML
    private TableColumn<Student, String> tabStudenciMiejscowosc;

    @FXML
    private TableColumn<Student, String> tabStudenciNazwisko;

    @FXML
    private TableColumn<Student, String> tabStudenciNrAlbumu;

    @FXML
    private TableColumn<Student, String> tabStudenciNrMieszkania;

    @FXML
    private TableColumn<Student, String> tabStudenciNrSemestru;

    @FXML
    private TableColumn<Student, String> tabStudenciNrTelefonu;

    @FXML
    private TableColumn<Student, String> tabStudenciPesel;

    @FXML
    private TableColumn<Student, String> tabStudenciUlica;

    @FXML
    private TableColumn<Wykladowca, Void> tabWykladowcyBtnDelete;

    @FXML
    private TableColumn<Wykladowca, Void> tabWykladowcyBtnEdit;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyIdWykladowcy;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyImie;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyNazwisko;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyPesel;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyMiasto;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyUlica;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyNrMieszkania;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyPensja;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyNrTelefonu;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyEmail;

    @FXML
    private TableColumn<Wykladowca, String> tabWykladowcyStopien;

    @FXML
    private TableView<Kierunek> tabelaKierunki;

    @FXML
    private TableView<Przedmiot> tabelaPrzedmioty;

    @FXML
    private TableView<Student> tabelaStudenci;

    @FXML
    private TableView<Wykladowca> tabelaWykladowcy;

    @FXML
    private TableView<WykladanyPrzedmiot> tabelaWP;

    @FXML
    private Pane topPane;

    //dodawanie studentów
    @FXML
    private TextField DSimie;

    @FXML
    private TextField DSnazwisko;

    @FXML
    private TextField DSpesel;

    @FXML
    private TextField DSalbum;

    @FXML
    private TextField DSsemestr;

    @FXML
    private TextField DStelefon;

    @FXML
    private TextField DSemail;

    @FXML
    private TextField DSmiejscowosc;

    @FXML
    private TextField DSulica;

    @FXML
    private TextField DSmieszkanie;

    @FXML
    private ComboBox<String> comboDSkolegium;

    @FXML
    private ComboBox<String> comboDSkierunek;

    @FXML
    private Pane paneDodajStudenta;

    //dodawanie wykladowców
    @FXML
    private TextField DWimie;

    @FXML
    private TextField DWnazwisko;

    @FXML
    private TextField DWpesel;

    @FXML
    private TextField DWtelefon;

    @FXML
    private TextField DWemail;

    @FXML
    private TextField DWmiejscowosc;

    @FXML
    private TextField DWulica;

    @FXML
    private TextField DWmieszkanie;

    @FXML
    private TextField DWpensja;

    @FXML
    private TextField DWstopien;

    @FXML
    private Pane paneDodajWykladowce;

    //dodawanie kierunków
    @FXML
    private TextField DKnazwa;

    @FXML
    private ComboBox<String> comboDKkolegium;

    @FXML
    private Pane paneDodajKierunek;

    //dodawanie przedmiotów
    @FXML
    private TextField DPnazwa;

    @FXML
    private ComboBox<String> comboDPkierunek;

    @FXML
    private Pane paneDodajPrzedmiot;

    //logowanie
    @FXML
    private TextField login;

    @FXML
    private TextField haslo;

    //wykladanyprzedmiot
    @FXML
    private TextField WPpesel;

    @FXML
    private ComboBox<String> comboWPkierunek;

    @FXML
    private ComboBox<String> comboWPprzedmiot;

    @FXML
    private Pane paneDodajWykladanyPrzedmiot;

    @FXML
    private Pane paneTabelaWP;

    @FXML
    private TableColumn<WykladanyPrzedmiot, String> tabWPid;

    @FXML
    private TableColumn<WykladanyPrzedmiot, String> tabWPpesel;

    @FXML
    private TableColumn<WykladanyPrzedmiot, String> tabWPkierunek;

    @FXML
    private TableColumn<WykladanyPrzedmiot, String> tabWPprzedmiot;

    @FXML
    private TableColumn<WykladanyPrzedmiot, Void> tabWPBtnEdit;

    @FXML
    private TableColumn<WykladanyPrzedmiot, Void> tabWPBtnDelete;

    @FXML
    private Pane paneWyszukajWP;

    @FXML
    private ComboBox<String> comboWyszukajWP;

    @FXML
    private TextField fieldWyszukajWP;

    @FXML
    private TextField fieldZapiszS;

    @FXML
    private ComboBox<String> comboZapiszS;

    @FXML
    private TextField fieldWczytajS;

    @FXML
    private ComboBox<String> comboWczytajS;

    //statystyki
    @FXML
    private Pane paneTabelaStatystyki;

    @FXML
    private TableView<Statystyka> tabelaStatystyki;

    @FXML
    private TableColumn<Statystyka, String> tabStatystykiNumer;

    @FXML
    private TableColumn<Statystyka, String> tabStatystykiNazwa;

    @FXML
    private TableColumn<Statystyka, String> tabStatystykiWartosc;

    @FXML
    private TableColumn<Statystyka, String> tabStatystykiData;

    @FXML
    private TextFlow textFlow;

    @FXML
    private Pane paneInfo;

    private DbAccess dbAccess;

    private Login loginService;

    public static User user;

    private StudentMethods studentMethods;

    private WykladowcaMethods wykladowcaMethods;

    private KierunekMethods kierunekMethods;

    private PrzedmiotMethods przedmiotMethods;

    private KolegiumMethods kolegiumMethods;

    private WykladanyPrzedmiotMethods wykladanyPrzedmiotMethods;

    private StatystykaMethods statystykaMethods;

    private CreateFunctions createFunctions;

    public static ObservableList<Student> studenci = FXCollections.observableArrayList();

    private final String[] comboWyszukajStudentaItems = {"nazwisko", "PESEL", "kierunek"};

    public static ObservableList<Wykladowca> wykladowcy = FXCollections.observableArrayList();

    private final String[] comboWyszukajWykladowceItems = {"nazwisko", "PESEL"};

    public static ObservableList<Kierunek> kierunki = FXCollections.observableArrayList();

    private final String[] comboWyszukajKierunekItems = {"nazwa"};

    public static ObservableList<Przedmiot> przedmioty = FXCollections.observableArrayList();

    private final String[] comboWyszukajPrzedmiotItems = {"nazwa"};

    public static ObservableList<WykladanyPrzedmiot> wykladanePrzedmioty = FXCollections.observableArrayList();

    private final String[] comboWyszukajWPItems = {"pesel"};

    public static ObservableList<Statystyka> statystyki = FXCollections.observableArrayList();

    /**
     * Itemy do combobox w panelu zapisu danych tabelido pliku.
     */
    private final String[] formatZapisz = {"xml", "txt", "bin"};
    /**
     * Itemy do combobox w panelu odczyu danych do tabeli z pliku.
     */
    private final String[] formatWczytaj = {"xml", "bin"};

    private final Text text = new Text("""
                                       
                                       Celem projektu było zaprojektowanie bazy danych przechowującej informacje 
                                       dotyczące funkcjonowania uczelni wyższej (tj. informacje na temat studentów, 
                                       kierunków, przedmiotów itp.) oraz stworzenie aplikacji obsługującej tą bazę danych.
                                      
                                       """);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbAccess = new DbAccess();
        labelBaza.setText(dbAccess.getDatabaseName());
        paneLogowanie.toFront();

        createFunctions = new CreateFunctions();
        createFunctions.create();
        
        text.setFill(Color.WHITE);
        textFlow.getChildren().add(text);
    }

    @FXML
    public void btnZaloguj(ActionEvent actionEvent) {
        loginService = new Login();

        if (!loginService.zaloguj(login.getText(), haslo.getText())) {
            return;
        }

        labelZalogowano.setText("Zalogowano jako: ");
        labelZalogowano.setText(labelZalogowano.getText() + " " + user.getLogin());

        login.clear();
        haslo.clear();

        comboWyszukajKierunek.getItems().clear();
        comboWyszukajPrzedmiot.getItems().clear();
        comboWyszukajStudenta.getItems().clear();
        comboWyszukajWykladowce.getItems().clear();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        //tabela studentów
        tabStudenciIdStudenta.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdStudenta())));

        tabStudenciIdKierunku.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdKierunku().getNazwa())));

        tabStudenciIdKolegium.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdKolegium().getNazwa())));

        tabStudenciImie.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getImie()));

        tabStudenciNazwisko.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNazwisko()));

        tabStudenciPesel.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getPesel()));

        tabStudenciNrAlbumu.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNrAlbumu()));

        tabStudenciNrSemestru.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNrSemestru()));

        tabStudenciNrTelefonu.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNrTelefonu()));

        tabStudenciEmail.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getEmail()));

        tabStudenciMiejscowosc.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getMiasto()));

        tabStudenciUlica.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getUlica()));

        tabStudenciNrMieszkania.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNrMieszkania()));

        //button edit
        tabStudenciBtnEdit.setCellFactory(new Callback<TableColumn<Student, Void>, TableCell<Student, Void>>() {
            @Override
            public TableCell<Student, Void> call(final TableColumn<Student, Void> param) {
                final TableCell<Student, Void> cell = new TableCell<Student, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/edit.png"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {
                                //pobranie studenta do kontrolera ramki
                                EditStudentController.student = getTableView().getItems().get(getIndex());
                                EditStudentController.row = getIndex();
                                EditStudentController.kryterium = comboWyszukajStudenta.getValue();
                                EditStudentController.wartosc = fieldWyszukajStudenta.getText();

                                try {
                                    Stage stage = new Stage();
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.setOpacity(1);
                                    stage.setTitle("Edit");
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Zasoby/EditStudent.fxml"));
                                    Parent root = fxmlLoader.load();
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.showAndWait();
                                } catch (IOException e) {
                                    alert.setTitle("ERROR");
                                    alert.setHeaderText("ERROR");
                                    alert.setContentText("Błąd załadowania modułu Edycji!");
                                    alert.showAndWait();
                                }
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //button delete
        tabStudenciBtnDelete.setCellFactory(new Callback<TableColumn<Student, Void>, TableCell<Student, Void>>() {
            @Override
            public TableCell<Student, Void> call(final TableColumn<Student, Void> param) {
                final TableCell<Student, Void> cell = new TableCell<Student, Void>() {

                    Image image = new Image("/Images/delete.jpg", 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {
                                Student s = getTableView().getItems().get(getIndex());
                                studentMethods.deleteStudent(s);
                                studenci.remove(s);
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        tabelaStudenci.setItems(studenci);

        //////////////////////////////////////////////////////////////////////////////
        //tabela wykladowcow
        tabWykladowcyIdWykladowcy.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdWykladowcy())));

        tabWykladowcyImie.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getImie()));

        tabWykladowcyNazwisko.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNazwisko()));

        tabWykladowcyPesel.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getPesel()));

        tabWykladowcyMiasto.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getMiasto()));

        tabWykladowcyUlica.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getUlica()));

        tabWykladowcyNrMieszkania.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNumerMieszkania()));

        tabWykladowcyPensja.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPensja())));

        tabWykladowcyNrTelefonu.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNumerTelefonu()));

        tabWykladowcyEmail.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getEmail()));

        tabWykladowcyStopien.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getStopien()));

        //button edit
        tabWykladowcyBtnEdit.setCellFactory(new Callback<TableColumn<Wykladowca, Void>, TableCell<Wykladowca, Void>>() {
            @Override
            public TableCell<Wykladowca, Void> call(final TableColumn<Wykladowca, Void> param) {
                final TableCell<Wykladowca, Void> cell = new TableCell<Wykladowca, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/edit.png"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {

                                //pobranie wykladowcy do kontrolera ramki
                                EditWykladowcaController.wykladowca = getTableView().getItems().get(getIndex());
                                EditWykladowcaController.row = getIndex();
                                EditWykladowcaController.kryterium = comboWyszukajWykladowce.getValue();
                                EditWykladowcaController.wartosc = fieldWyszukajWykladowce.getText();

                                try {
                                    Stage stage = new Stage();
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.setOpacity(1);
                                    stage.setTitle("Edit");
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Zasoby/EditWykladowca.fxml"));
                                    Parent root = fxmlLoader.load();
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.showAndWait();
                                } catch (IOException e) {
                                    alert.setTitle("ERROR");
                                    alert.setHeaderText("ERROR");
                                    alert.setContentText("Błąd załadowania modułu Edycji!");
                                    alert.showAndWait();
                                }
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //button delete
        tabWykladowcyBtnDelete.setCellFactory(new Callback<TableColumn<Wykladowca, Void>, TableCell<Wykladowca, Void>>() {
            @Override
            public TableCell<Wykladowca, Void> call(final TableColumn<Wykladowca, Void> param) {
                final TableCell<Wykladowca, Void> cell = new TableCell<Wykladowca, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/delete.jpg"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {
                                Wykladowca w = getTableView().getItems().get(getIndex());
                                wykladowcaMethods.deleteWykladowca(w);
                                wykladowcy.remove(w);
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        tabelaWykladowcy.setItems(wykladowcy);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        //tabela kierunków
        tabKierunkiIdKierunku.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdKierunku())));

        tabKierunkiIdKolegium.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdKolegium().getNazwa())));

        tabKierunkiNazwa.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNazwa()));

        //button edit
        tabKierunkiBtnEdit.setCellFactory(new Callback<TableColumn<Kierunek, Void>, TableCell<Kierunek, Void>>() {
            @Override
            public TableCell<Kierunek, Void> call(final TableColumn<Kierunek, Void> param) {
                final TableCell<Kierunek, Void> cell = new TableCell<Kierunek, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/edit.png"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {

                                //pobranie kierunku do kontrolera ramki
                                EditKierunekController.kierunek = getTableView().getItems().get(getIndex());
                                EditKierunekController.row = getIndex();
                                EditKierunekController.kryterium = comboWyszukajKierunek.getValue();
                                EditKierunekController.wartosc = fieldWyszukajKierunek.getText();

                                try {
                                    Stage stage = new Stage();
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.setOpacity(1);
                                    stage.setTitle("Edit");
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Zasoby/EditKierunek.fxml"));
                                    Parent root = fxmlLoader.load();
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.showAndWait();
                                } catch (IOException e) {
                                    alert.setTitle("ERROR");
                                    alert.setHeaderText("ERROR");
                                    alert.setContentText("Błąd załadowania modułu Edycji!");
                                    alert.showAndWait();
                                }
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //button delete
        tabKierunkiBtnDelete.setCellFactory(new Callback<TableColumn<Kierunek, Void>, TableCell<Kierunek, Void>>() {
            @Override
            public TableCell<Kierunek, Void> call(final TableColumn<Kierunek, Void> param) {
                final TableCell<Kierunek, Void> cell = new TableCell<Kierunek, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/delete.jpg"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {
                                Kierunek k = getTableView().getItems().get(getIndex());
                                if (kierunekMethods.deleteKierunek(k)) {
                                    kierunki.remove(k);
                                }
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        tabelaKierunki.setItems(kierunki);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        //tabela przedmiotów
        tabPrzedmiotyIdPrzedmiotu.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdPrzedmiotu())));

        tabPrzedmiotyIdKierunku.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdKierunku().getNazwa())));

        tabPrzedmiotyNazwa.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNazwa()));

        //button edit
        tabPrzedmiotyBtnEdit.setCellFactory(new Callback<TableColumn<Przedmiot, Void>, TableCell<Przedmiot, Void>>() {
            @Override
            public TableCell<Przedmiot, Void> call(final TableColumn<Przedmiot, Void> param) {
                final TableCell<Przedmiot, Void> cell = new TableCell<Przedmiot, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/edit.png"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {

                                //pobranie przedmiotu do kontrolera ramki
                                EditPrzedmiotController.przedmiot = getTableView().getItems().get(getIndex());
                                EditPrzedmiotController.row = getIndex();
                                EditPrzedmiotController.kryterium = comboWyszukajPrzedmiot.getValue();
                                EditPrzedmiotController.wartosc = fieldWyszukajPrzedmiot.getText();

                                try {
                                    Stage stage = new Stage();
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.setOpacity(1);
                                    stage.setTitle("Edit");
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Zasoby/EditPrzedmiot.fxml"));
                                    Parent root = fxmlLoader.load();
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.showAndWait();
                                } catch (IOException e) {
                                    alert.setTitle("ERROR");
                                    alert.setHeaderText("ERROR");
                                    alert.setContentText("Błąd załadowania modułu Edycji!");
                                    alert.showAndWait();
                                }
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //button delete
        tabPrzedmiotyBtnDelete.setCellFactory(new Callback<TableColumn<Przedmiot, Void>, TableCell<Przedmiot, Void>>() {
            @Override
            public TableCell<Przedmiot, Void> call(final TableColumn<Przedmiot, Void> param) {
                final TableCell<Przedmiot, Void> cell = new TableCell<Przedmiot, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/delete.jpg"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {
                                Przedmiot p = getTableView().getItems().get(getIndex());
                                przedmiotMethods.deletePrzedmiot(p);
                                przedmioty.remove(p);
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff;");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        tabelaPrzedmioty.setItems(przedmioty);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        //tabela wykladany przedmiot
        tabWPid.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdWykladanePrzedmioty())));

        tabWPpesel.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdWykladowcy().getPesel())));

        tabWPkierunek.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getIdKierunku().getNazwa()));

        tabWPprzedmiot.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getIdPrzedmiotu().getNazwa()));

        //button edit
        tabWPBtnEdit.setCellFactory(new Callback<TableColumn<WykladanyPrzedmiot, Void>, TableCell<WykladanyPrzedmiot, Void>>() {
            @Override
            public TableCell<WykladanyPrzedmiot, Void> call(final TableColumn<WykladanyPrzedmiot, Void> param) {
                final TableCell<WykladanyPrzedmiot, Void> cell = new TableCell<WykladanyPrzedmiot, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/edit.png"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {

                                //pobranie przedmiotu do kontrolera ramki
                                EditWykladanyPrzedmiotController.wykladanyPrzedmiot = getTableView().getItems().get(getIndex());
                                EditWykladanyPrzedmiotController.row = getIndex();
                                EditWykladanyPrzedmiotController.kryterium = comboWyszukajWP.getValue();
                                EditWykladanyPrzedmiotController.wartosc = fieldWyszukajWP.getText();

                                try {
                                    Stage stage = new Stage();
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.setOpacity(1);
                                    stage.setTitle("Edit");
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Zasoby/EditWykladanyPrzedmiot.fxml"));
                                    Parent root = fxmlLoader.load();
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.showAndWait();
                                } catch (IOException e) {
                                    alert.setTitle("ERROR");
                                    alert.setHeaderText("ERROR");
                                    alert.setContentText("Błąd załadowania modułu Edycji!");
                                    alert.showAndWait();
                                }
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff; ");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //button delete
        tabWPBtnDelete.setCellFactory(new Callback<TableColumn<WykladanyPrzedmiot, Void>, TableCell<WykladanyPrzedmiot, Void>>() {
            @Override
            public TableCell<WykladanyPrzedmiot, Void> call(final TableColumn<WykladanyPrzedmiot, Void> param) {
                final TableCell<WykladanyPrzedmiot, Void> cell = new TableCell<WykladanyPrzedmiot, Void>() {

                    Image image = new Image(getClass().getResourceAsStream("/Images/delete.jpg"), 25, 25, false, false);
                    private final Button btn = new Button();

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            if (user.getRola().equals("admin")) {
                                WykladanyPrzedmiot wp = getTableView().getItems().get(getIndex());
                                wykladanyPrzedmiotMethods.deleteWykladanyPrzedmiot(wp);
                                wykladanePrzedmioty.remove(wp);
                            } else {
                                alert.setTitle("ERROR");
                                alert.setHeaderText("ERROR");
                                alert.setContentText("Brak uprawnień.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setStyle("-fx-background-color: #ffffff;");
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        tabelaWP.setItems(wykladanePrzedmioty);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        //tabela statystyki
        tabStatystykiNumer.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumer())));

        tabStatystykiNazwa.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNazwa())));

        tabStatystykiWartosc.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getWartosc())));

        tabStatystykiData.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getData()));

        tabelaStatystyki.setItems(statystyki);

        //tworzenie obiektów
        studentMethods = new StudentMethods();
        wykladowcaMethods = new WykladowcaMethods();
        kierunekMethods = new KierunekMethods();
        przedmiotMethods = new PrzedmiotMethods();
        kolegiumMethods = new KolegiumMethods();
        wykladanyPrzedmiotMethods = new WykladanyPrzedmiotMethods();
        statystykaMethods = new StatystykaMethods();

        //ustawianie comboboxów
        comboWyszukajKierunek.getItems().addAll(comboWyszukajKierunekItems);
        comboWyszukajStudenta.getItems().addAll(comboWyszukajStudentaItems);
        comboWyszukajWykladowce.getItems().addAll(comboWyszukajWykladowceItems);
        comboWyszukajPrzedmiot.getItems().addAll(comboWyszukajPrzedmiotItems);
        comboWyszukajWP.getItems().addAll(comboWyszukajWPItems);
        comboZapiszS.getItems().addAll(formatZapisz);
        comboZapiszS.getSelectionModel().selectFirst();
        comboWczytajS.getItems().addAll(formatWczytaj);
        comboWczytajS.getSelectionModel().selectFirst();

        //listener na zmiane itemu w comboBox
        comboDSkolegium.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldvalue, String newvalue) {//zmiana itemu
                try{
                comboDSkierunek.getItems().clear();//wyczyszczenie listy
                comboDSkierunek.getItems().addAll(kierunekMethods.pobierzKierunki(comboDSkolegium.getValue()));
                comboDSkierunek.getSelectionModel().selectFirst();
                }catch(Exception e){};
            }
        });

        comboWPkierunek.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldvalue, String newvalue) {//zmiana itemu
                try{
                comboWPprzedmiot.getItems().clear();//wyczyszczenie listy
                comboWPprzedmiot.getItems().addAll(przedmiotMethods.pobierzPrzedmioty(comboWPkierunek.getValue()));
                comboWPprzedmiot.getSelectionModel().selectFirst();
                }catch(Exception e){}
            }
        });

        tabelaStudenci.setPlaceholder(new Label("Brak danych w tabeli"));
        tabelaWykladowcy.setPlaceholder(new Label("Brak danych w tabeli"));
        tabelaKierunki.setPlaceholder(new Label("Brak danych w tabeli"));
        tabelaPrzedmioty.setPlaceholder(new Label("Brak danych w tabeli"));
        tabelaWP.setPlaceholder(new Label("Brak danych w tabeli"));

        statystykaMethods.utworzTabele();

        leftPane.toFront();
        topPane.toFront();
        stack.toFront();
        paneWyszukajStudenta.toFront();
        paneTabelaStudenci.toFront();
    }

    @FXML
    public void btnWyloguj(ActionEvent actionEvent) {
        user = null;
        paneLogowanie.toFront();
    }

     /**
     * Wyświetla widok wyszukiwania studentów
     *
     * @param event
     */
    @FXML
    void menuWyszukajStudentow(ActionEvent event) {
        comboZapiszS.getItems().clear();
        comboWczytajS.getItems().clear();
        comboZapiszS.getItems().addAll(formatZapisz);
        comboZapiszS.getSelectionModel().selectFirst();
        comboWczytajS.getItems().addAll(formatWczytaj);
        comboWczytajS.getSelectionModel().selectFirst();
        paneWyszukajStudenta.toFront();
        paneTabelaStudenci.toFront();
    }

     /**
     * Wyświetla widok wyszukiwania kierunków
     *
     * @param event
     */
    @FXML
    void menuWyszukajKierunki(ActionEvent event) {
        paneWyszukajKierunek.toFront();
        paneTabelaKierunki.toFront();
    }

     /**
     * Wyświetla widok wyszukiwania wykładowców
     *
     * @param event
     */
    @FXML
    void menuWyszukajWykladowcow(ActionEvent event) {
        paneWyszukajWykladowce.toFront();
        paneTabelaWykladowcy.toFront();
    }

     /**
     * Wyświetla widok wyszukiwania przedmiotów
     *
     * @param event
     */    
    @FXML
    void menuWyszukajPrzedmioty(ActionEvent event) {
        paneWyszukajPrzedmiot.toFront();
        paneTabelaPrzedmioty.toFront();
    }

     /**
     * Wyświetla widok wyszukiwania wykładanych przedmiotów
     *
     * @param event
     */
    @FXML
    void menuWyszukajWP(ActionEvent event) {
        paneWyszukajWP.toFront();
        paneTabelaWP.toFront();
    }

     /**
     * Wyświetla widok dodawania studentów
     *
     * @param event
     */
    @FXML
    void menuDodajStudentow(ActionEvent event) {
        if (user.getRola().equals("admin")) {
            comboDSkolegium.getItems().clear();
            comboDSkierunek.getItems().clear();
            try {
                comboDSkolegium.getItems().addAll(kolegiumMethods.pobierzKolegia());
                comboDSkolegium.getSelectionModel().selectFirst();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            paneDodajStudenta.toFront();
            paneTabelaStudenci.toFront();
        } else {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("Brak uprawnień.");
            alert.showAndWait();
        }
    }

     /**
     * Wyświetla widok dodawania wykładowców
     *
     * @param event
     */
    @FXML
    void menuDodajWykladowcow(ActionEvent event) {
        if (user.getRola().equals("admin")) {
            paneDodajWykladowce.toFront();
            paneTabelaWykladowcy.toFront();
        } else {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("Brak uprawnień.");
            alert.showAndWait();
        }
    }

     /**
     * Wyświetla widok dodawania kierunków
     *
     * @param event
     */
    @FXML
    void menuDodajKierunki(ActionEvent event) {
        if (user.getRola().equals("admin")) {
            comboDKkolegium.getItems().clear();
            try {
                comboDKkolegium.getItems().addAll(kolegiumMethods.pobierzKolegia());
                comboDKkolegium.getSelectionModel().selectFirst();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            paneDodajKierunek.toFront();
            paneTabelaKierunki.toFront();
        } else {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("Brak uprawnień.");
            alert.showAndWait();
        }
    }

     /**
     * Wyświetla widok dodawania przedmiotów
     *
     * @param event
     */
    @FXML
    void menuDodajPrzedmioty(ActionEvent event) {
        if (user.getRola().equals("admin")) {
            comboDPkierunek.getItems().clear();
            try {
                comboDPkierunek.getItems().addAll(kierunekMethods.pobierzKierunki2());
                comboDPkierunek.getSelectionModel().selectFirst();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            paneDodajPrzedmiot.toFront();
            paneTabelaPrzedmioty.toFront();
        } else {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("Brak uprawnień.");
            alert.showAndWait();
        }
    }

     /**
     * Wyświetla widok dodawania wykładanych przedmiotów
     *
     * @param event
     */
    @FXML
    void menuDodajWP(ActionEvent event) {
        if (user.getRola().equals("admin")) {
            comboWPkierunek.getItems().clear();
            try {
                comboWPkierunek.getItems().addAll(kierunekMethods.pobierzKierunki2());
                comboWPkierunek.getSelectionModel().selectFirst();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            paneDodajWykladanyPrzedmiot.toFront();
            paneTabelaWP.toFront();
        } else {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");
            alert.setContentText("Brak uprawnień.");
            alert.showAndWait();
        }
    }

     /**
     * Wyświetla widok statystyk
     *
     * @param event
     */
    @FXML
    void menuWyswietlStatystyki(ActionEvent event) {
        statystykaMethods.aktualizuj();
        tabelaStatystyki.getItems().clear();
        statystyki.setAll(statystykaMethods.pobierzStatystyki());
        paneTabelaStatystyki.toFront();
    }

     /**
     * Wyświetla widok info
     *
     * @param event
     */
    @FXML
    void menuInfo(ActionEvent event) {
        paneInfo.toFront();
    }

    //////////////////////////////////////////////////////////////////////////////

    /**
     * Wywołuje metodę wyszukania studentów 
     *
     * @param event
     */
    @FXML
    void wyszukajStudenta(ActionEvent event) {
        try {
            if (fieldWyszukajStudenta.getText().equals("")) {
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");
                alert.setContentText("Nie można wyszukać. Uzupełnij dane.");
                alert.showAndWait();
            } else if (comboWyszukajStudenta.getValue().equals("PESEL")) {
                int error = 0;
                int i = 0;

                if (fieldWyszukajStudenta.getText().length() != 11) {
                    error++;
                    alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
                    alert.showAndWait();
                }

                i--;
                String pesel = fieldWyszukajStudenta.getText();
                char[] charsPesel = pesel.toCharArray();
                for (char c : charsPesel) {
                    if (!Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Pesel zawiera litery.");
                        alert.showAndWait();
                    }
                }

                if (error == 0) {
                    tabelaStudenci.getItems().clear();
                    studenci.setAll(studentMethods.wyszukajWgPeselu(fieldWyszukajStudenta.getText()));
                }
            } else if (comboWyszukajStudenta.getValue().equals("nazwisko")) {
                int error = 0;
                int i = 0;

                String nazwisko = fieldWyszukajStudenta.getText();
                char[] charsNazwisko = nazwisko.toCharArray();
                for (char c : charsNazwisko) {
                    if (Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Nazwisko zawiera cyfry.");
                        alert.showAndWait();
                    }
                }
                if (error == 0) {
                    tabelaStudenci.getItems().clear();
                    studenci.setAll(studentMethods.wyszukajWgNazwiska(fieldWyszukajStudenta.getText()));
                }
            } else if (comboWyszukajStudenta.getValue().equals("kierunek")) {
                int error = 0;
                int i = 0;

                String kierunek = fieldWyszukajStudenta.getText();
                char[] charsKierunek = kierunek.toCharArray();
                for (char c : charsKierunek) {
                    if (Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Kierunek zawiera cyfry.");
                        alert.showAndWait();
                    }
                }
                if (error == 0) {
                    tabelaStudenci.getItems().clear();
                    studenci.setAll(studentMethods.wyszukajWgKierunku(fieldWyszukajStudenta.getText()));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę wyszukania wykładowców 
     *
     * @param event
     */
    @FXML
    void wyszukajWykladowce(ActionEvent event) {
        try {
            if (fieldWyszukajWykladowce.getText().equals("")) {
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");
                alert.setContentText("Nie można wyszukać. Uzupełnij dane.");
                alert.showAndWait();
            } else if (comboWyszukajWykladowce.getValue().equals("PESEL")) {
                int error = 0;
                int i = 0;

                if (fieldWyszukajWykladowce.getText().length() != 11) {
                    error++;
                    alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
                    alert.showAndWait();
                }

                i--;
                String pesel = fieldWyszukajWykladowce.getText();
                char[] charsPesel = pesel.toCharArray();
                for (char c : charsPesel) {
                    if (!Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Pesel zawiera litery.");
                        alert.showAndWait();
                    }
                }

                if (error == 0) {
                    tabelaWykladowcy.getItems().clear();
                    wykladowcy.setAll(wykladowcaMethods.wyszukajWgPeselu(fieldWyszukajWykladowce.getText()));
                }
            } else if (comboWyszukajWykladowce.getValue().equals("nazwisko")) {
                int error = 0;
                int i = 0;

                String nazwisko = fieldWyszukajWykladowce.getText();
                char[] charsNazwisko = nazwisko.toCharArray();
                for (char c : charsNazwisko) {
                    if (Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Nazwisko zawiera cyfry.");
                        alert.showAndWait();
                    }
                }
                if (error == 0) {
                    tabelaWykladowcy.getItems().clear();
                    wykladowcy.setAll(wykladowcaMethods.wyszukajWgNazwiska(fieldWyszukajWykladowce.getText()));
                }
            }
        } catch (Exception e) {
        }
    }

     /**
     * Wywołuje metodę wyszukania kierunków 
     *
     * @param event
     */
    @FXML
    void wyszukajKierunek(ActionEvent event) {
        try {
            if (fieldWyszukajKierunek.getText().equals("")) {
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");
                alert.setContentText("Nie można wyszukać. Uzupełnij dane.");
                alert.showAndWait();
            } else if (comboWyszukajKierunek.getValue().equals("nazwa")) {
                int error = 0;
                int i = 0;

                String nazwa = fieldWyszukajKierunek.getText();
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
                    tabelaWykladowcy.getItems().clear();
                    kierunki.setAll(kierunekMethods.wyszukajWgNazwy(fieldWyszukajKierunek.getText()));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę wyszukania przedmiotów 
     *
     * @param event
     */
    @FXML
    void wyszukajPrzedmiot(ActionEvent event) {
        try {
            if (fieldWyszukajPrzedmiot.getText().equals("")) {
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");
                alert.setContentText("Nie można wyszukać. Uzupełnij dane.");
                alert.showAndWait();
            } else if (comboWyszukajPrzedmiot.getValue().equals("nazwa")) {
                int error = 0;
                int i = 0;

                String nazwa = fieldWyszukajPrzedmiot.getText();
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
                    tabelaPrzedmioty.getItems().clear();
                    przedmioty.setAll(przedmiotMethods.wyszukajWgNazwy(fieldWyszukajPrzedmiot.getText()));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę wyszukania wykładanych przedmiotów 
     *
     * @param event
     */
    @FXML
    void wyszukajWP(ActionEvent event) {
        try {
            if (fieldWyszukajWP.getText().equals("")) {
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");
                alert.setContentText("Nie można wyszukać. Uzupełnij dane.");
                alert.showAndWait();
            } else if (comboWyszukajWP.getValue().equals("pesel")) {
                int error = 0;
                int i = 0;

                if (fieldWyszukajWP.getText().length() != 11) {
                    error++;
                    alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
                    alert.showAndWait();
                }

                i--;
                String pesel = fieldWyszukajWP.getText();
                char[] charsPesel = pesel.toCharArray();
                for (char c : charsPesel) {
                    if (!Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Pesel zawiera litery.");
                        alert.showAndWait();
                    }
                }

                if (error == 0) {
                    tabelaWP.getItems().clear();
                    wykladanePrzedmioty.setAll(wykladanyPrzedmiotMethods.wyszukajWgPeselu(fieldWyszukajWP.getText()));
                }
            }
        } catch (Exception e) {
        }
    }

////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Wywołuje metodę dodania studenta do bazy danych.
     *
     * @param actionEvent
     */
    @FXML
    public void dodajStudenta(ActionEvent actionEvent) {
        try {
            int error = 0;
            int i = 0;

            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");

            if (DSimie.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz imię.");
                alert.showAndWait();
            } else {
                String imie = DSimie.getText();
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

            if (DSnazwisko.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz nazwisko.");
                alert.showAndWait();
            } else {
                i = 0;
                String nazwisko = DSnazwisko.getText();
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

            if (DSpesel.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz pesel.");
                alert.showAndWait();
            } else if (DSpesel.getText().length() != 11) {
                error++;
                alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
                alert.showAndWait();
            } else {
                i = 0;
                String pesel = DSpesel.getText();
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

            if (DStelefon.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz numer telefonu.");
                alert.showAndWait();
            } else if (DStelefon.getText().length() != 9) {
                error++;
                alert.setContentText("Numer telefonu nie zawiera 9 cyfr.");
                alert.showAndWait();
            } else {
                i = 0;
                String nrTel = DStelefon.getText();
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

            if (DSemail.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz e-mail.");
                alert.showAndWait();
            } else {
                //Regular Expression   
                String regex = "^(.+)@(.+)$";
                //Compile regular expression to get the pattern  
                Pattern pattern = Pattern.compile(regex);

                if (!pattern.matcher(DSemail.getText()).matches()) {
                    error++;
                    alert.setContentText("Zły format email.");
                    alert.showAndWait();
                }
            }

            if (DSmiejscowosc.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz miejscowosc.");
                alert.showAndWait();
            } else {
                i = 0;
                String miejscowosc = DSmiejscowosc.getText();
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

            if (DSulica.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz ulicę.");
                alert.showAndWait();
            } else {
                i = 0;
                String ulica = DSulica.getText();
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

            if (DSmieszkanie.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz mieszkanie.");
                alert.showAndWait();
            } else {
                i = 0;
                String nrMieszkania = DSmieszkanie.getText();
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

            if (DSalbum.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz numer albumu.");
                alert.showAndWait();
            } else if (DSalbum.getText().length() != 6) {
                error++;
                alert.setContentText("Numer albumu nie zawiera 6 cyfr.");
                alert.showAndWait();
            } else {
                i = 0;
                String album = DSalbum.getText();
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

            if (DSsemestr.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz numer semestru.");
                alert.showAndWait();
            } else {
                i = 0;
                String semestr = DSsemestr.getText();
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

                Student s = studentMethods.saveStudent(comboDSkierunek.getValue(), comboDSkolegium.getValue(), DSimie.getText(), DSnazwisko.getText(), DSpesel.getText(), DSmiejscowosc.getText(), DSulica.getText(), DSmieszkanie.getText(), DStelefon.getText(), DSemail.getText(), DSsemestr.getText(), DSalbum.getText());

                if (fieldWyszukajStudenta.getText().equals(DSpesel.getText()) || fieldWyszukajStudenta.getText().equals(DSnazwisko.getText())) {
                    studenci.add(s);
                }

                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Pomyślnie dodano.");
                alert.showAndWait();
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę dodania wykładowcy do bazy danych.
     *
     * @param actionEvent
     */
    @FXML
    public void dodajWykladowce(ActionEvent actionEvent) {
        try {
            if (wykladowcaMethods.wyszukajWykladowce(DWpesel.getText())) {
                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Wykladowca o podanym numerze PESEL już istnieje.");
                alert.showAndWait();
            } else {

                int error = 0;
                int i = 0;

                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");

                if (DWimie.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz imię.");
                    alert.showAndWait();
                } else {
                    String imie = DWimie.getText();
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

                if (DWnazwisko.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz nazwisko.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String nazwisko = DWnazwisko.getText();
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

                if (DWpesel.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz pesel.");
                    alert.showAndWait();
                } else if (DWpesel.getText().length() != 11) {
                    error++;
                    alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String pesel = DWpesel.getText();
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

                if (DWtelefon.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz numer telefonu.");
                    alert.showAndWait();
                } else if (DWtelefon.getText().length() != 9) {
                    error++;
                    alert.setContentText("Numer telefonu nie zawiera 9 cyfr.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String nrTel = DWtelefon.getText();
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

                if (DWemail.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz e-mail.");
                    alert.showAndWait();
                } else {
                    String regex = "^(.+)@(.+)$";
                    Pattern pattern = Pattern.compile(regex);

                    if (!pattern.matcher(DWemail.getText()).matches()) {
                        error++;
                        alert.setContentText("Zły format email.");
                        alert.showAndWait();
                    }
                }

                if (DWmiejscowosc.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz miejscowosc.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String miejscowosc = DWmiejscowosc.getText();
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

                if (DWulica.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz ulicę.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String ulica = DWulica.getText();
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

                if (DWmieszkanie.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz mieszkanie.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String nrMieszkania = DWmieszkanie.getText();
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

                if (DWpensja.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz pensję.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String pensja = DWpensja.getText();
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

                if (DWstopien.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz stopień.");
                    alert.showAndWait();
                } else {
                    i = 0;
                    String stopien = DWstopien.getText();
                    char[] charsStopien = stopien.toCharArray();
                    for (char c : charsStopien) {
                        if (Character.isDigit(c) && i == 0) {
                            i++;
                            error++;
                            alert.setContentText("Stopien zawiera cyfry.");
                            alert.showAndWait();
                        }
                    }
                }

                if (error == 0) {

                    Wykladowca w = wykladowcaMethods.saveWykladowca(DWimie.getText(), DWnazwisko.getText(), DWpesel.getText(), DWmiejscowosc.getText(), DWulica.getText(), DWmieszkanie.getText(), DWpensja.getText(), DWtelefon.getText(), DWemail.getText(), DWstopien.getText());

                    if (fieldWyszukajWykladowce.getText().equals(DWpesel.getText()) || fieldWyszukajWykladowce.getText().equals(DWnazwisko.getText())) {
                        wykladowcy.add(w);
                    }

                    alert.setTitle("Info");
                    alert.setHeaderText("Info");
                    alert.setContentText("Pomyślnie dodano.");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę dodania kierunku do bazy danych.
     *
     * @param actionEvent
     */
    @FXML
    public void dodajKierunek(ActionEvent actionEvent) {
        try {
            if (kierunekMethods.wyszukajKierunek(DKnazwa.getText())) {
                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Kierunek o podanej nazwie już istnieje.");
                alert.showAndWait();
            } else {
                int error = 0;
                int i = 0;

                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");

                if (DKnazwa.getText().equals("")) {
                    error++;
                    alert.setContentText("Wpisz nazwę.");
                    alert.showAndWait();
                } else {
                    String nazwa = DKnazwa.getText();
                    char[] charsNazwa = nazwa.toCharArray();
                    for (char c : charsNazwa) {
                        if (Character.isDigit(c) && i == 0) {
                            i++;
                            error++;
                            alert.setContentText("Nazwa zawiera cyfry.");
                            alert.showAndWait();
                        }
                    }
                }

                if (error == 0) {

                    Kierunek k = kierunekMethods.saveKierunek(DKnazwa.getText(), comboDKkolegium.getValue());

                    if (fieldWyszukajKierunek.getText().equals(DKnazwa.getText())) {
                        kierunki.add(k);
                    }

                    alert.setTitle("Info");
                    alert.setHeaderText("Info");
                    alert.setContentText("Pomyślnie dodano.");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę dodania przedmiotu do bazy danych.
     *
     * @param actionEvent
     */
    @FXML
    public void dodajPrzedmiot(ActionEvent actionEvent) {
        try {
            int error = 0;
            int i = 0;
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");

            if (DPnazwa.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz nazwę.");
                alert.showAndWait();
            } else {
                String nazwa = DPnazwa.getText();
                char[] charsNazwa = nazwa.toCharArray();
                for (char c : charsNazwa) {
                    if (Character.isDigit(c) && i == 0) {
                        i++;
                        error++;
                        alert.setContentText("Nazwa zawiera cyfry.");
                        alert.showAndWait();
                    }
                }
            }

            if (error == 0) {

                Przedmiot p = przedmiotMethods.savePrzedmiot(DPnazwa.getText(), comboDPkierunek.getValue());

                if (fieldWyszukajPrzedmiot.getText().equals(DPnazwa.getText())) {
                    przedmioty.add(p);
                }

                alert.setTitle("Info");
                alert.setHeaderText("Info");
                alert.setContentText("Pomyślnie dodano.");
                alert.showAndWait();
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wywołuje metodę dodania wykładanego przedmiotu do bazy danych.
     *
     * @param actionEvent
     */
    @FXML
    public void dodajWykladanyPrzedmiot(ActionEvent actionEvent) {
        try {
            int error = 0;
            int i = 0;

            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");

            if (WPpesel.getText().equals("")) {
                error++;
                alert.setContentText("Wpisz pesel.");
                alert.showAndWait();
            } else if (WPpesel.getText().length() != 11) {
                error++;
                alert.setContentText("Numer PESEL nie zawiera 11 cyfr.");
                alert.showAndWait();
            } else {
                i = 0;
                String pesel = WPpesel.getText();
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

                WykladanyPrzedmiot wp = wykladanyPrzedmiotMethods.saveWykladanyPrzedmiot(WPpesel.getText(), comboWPprzedmiot.getValue(), comboWPkierunek.getValue());

                if (wp == null) {
                    alert.setTitle("Info");
                    alert.setHeaderText("Info");
                    alert.setContentText("Błąd.");
                    alert.showAndWait();
                } else {
                    if (fieldWyszukajWP.getText().equals(WPpesel.getText())) {
                        wykladanePrzedmioty.add(wp);
                    }
                    alert.setTitle("Info");
                    alert.setHeaderText("Info");
                    alert.setContentText("Pomyślnie dodano.");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Zapisuje dane z tabeli studentów do formatów XML, TXT lub BIN.
     *
     * @param actionEvent
     */
    @FXML
    public void btnZapiszS(ActionEvent actionEvent) {
        try {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");

            if (fieldZapiszS.getText().equals("")) {
                alert.setContentText("Podaj nazwę pliku.");
                alert.showAndWait();
            }

            if (comboZapiszS.getValue().equals("xml")) {//wybrany format xml
                try {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                    //utworzenie dokumentu
                    Document doc = dBuilder.newDocument();

                    // Utworzenie korzenia o nazwie studenci
                    Element rootElement = doc.createElement("Studenci");
                    // Dodanie korzenia studenci do dokumentu
                    doc.appendChild(rootElement);

                    // dla wiersza tabeli w liście:
                    for (Student elem : studenci) {
                        // Dodanie nowej gałęzi student do korzenia studenci
                        Element student = doc.createElement("Student");
                        rootElement.appendChild(student);

                        // Utworzenie nowej gałęzi idStudenta
                        Element idStudenta = doc.createElement("idStudenta");
                        // Utworzenie wartości dla gałęzi i doadnie jej.
                        idStudenta.appendChild(doc.createTextNode(String.valueOf(elem.getIdStudenta())));
                        // Dodanie gałęzi idStudenta do studenta
                        student.appendChild(idStudenta);

                        Element kierunek = doc.createElement("kierunek");
                        kierunek.appendChild(doc.createTextNode(elem.getIdKierunku().getNazwa()));
                        student.appendChild(kierunek);

                        Element kolegium = doc.createElement("kolegium");
                        kolegium.appendChild(doc.createTextNode(elem.getIdKolegium().getNazwa()));
                        student.appendChild(kolegium);

                        Element imie = doc.createElement("imie");
                        imie.appendChild(doc.createTextNode(elem.getImie()));
                        student.appendChild(imie);

                        Element nazwisko = doc.createElement("nazwisko");
                        nazwisko.appendChild(doc.createTextNode(elem.getNazwisko()));
                        student.appendChild(nazwisko);

                        Element pesel = doc.createElement("pesel");
                        pesel.appendChild(doc.createTextNode(elem.getPesel()));
                        student.appendChild(pesel);

                        Element nrAlbumu = doc.createElement("nrAlbumu");
                        nrAlbumu.appendChild(doc.createTextNode(elem.getNrAlbumu()));
                        student.appendChild(nrAlbumu);

                        Element nrSemestru = doc.createElement("nrSemestru");
                        nrSemestru.appendChild(doc.createTextNode(elem.getNrSemestru()));
                        student.appendChild(nrSemestru);

                        Element nrTelefonu = doc.createElement("nrTelefonu");
                        nrTelefonu.appendChild(doc.createTextNode(elem.getNrTelefonu()));
                        student.appendChild(nrTelefonu);

                        Element email = doc.createElement("email");
                        email.appendChild(doc.createTextNode(elem.getEmail()));
                        student.appendChild(email);

                        Element miejscowosc = doc.createElement("miejscowosc");
                        miejscowosc.appendChild(doc.createTextNode(elem.getMiasto()));
                        student.appendChild(miejscowosc);

                        Element ulica = doc.createElement("ulica");
                        ulica.appendChild(doc.createTextNode(elem.getUlica()));
                        student.appendChild(ulica);

                        Element nrMieszkania = doc.createElement("nrMieszkania");
                        nrMieszkania.appendChild(doc.createTextNode(elem.getNrMieszkania()));
                        student.appendChild(nrMieszkania);
                    }

                    // zapis do xml
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(fieldZapiszS.getText() + ".xml"));
                    transformer.transform(source, result);
                    alert.setContentText("Zapisano do formatu XML.");
                    alert.showAndWait();
                } catch (Exception exc) {
                    alert.setContentText("Błąd zapisu formatu XML.");
                    alert.showAndWait();
                }
            }
            if (comboZapiszS.getValue().equals("txt")) {//wybrany format txt
                try (FileWriter fw = new FileWriter(fieldZapiszS.getText() + ".txt", false);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)) {

                    out.write("Data utworzenia pliku: " + LocalDateTime.now().toLocalDate());
                    out.println();
                    out.write("Godzina utworzenia pliku: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
                    out.println();
                    out.println();

                    int i = 0;
                    for (Student s : studenci) {//dla kazdego obiektu w liscie
                        i++;
                        out.write("wiersz " + i);
                        out.println();
                        out.write("ID studenta: ");
                        out.write(String.valueOf(s.getIdStudenta()));
                        out.println();
                        out.write("Numer albumu: ");
                        out.write(s.getNrAlbumu());
                        out.println();
                        out.write("PESEL: ");
                        out.write(s.getPesel());
                        out.println();
                        out.write("Imię: ");
                        out.write(s.getImie());
                        out.println();
                        out.write("Nazwisko: ");
                        out.write(s.getNazwisko());
                        out.println();
                        out.write("Numer telefonu: ");
                        out.write(s.getNrTelefonu());
                        out.println();
                        out.write("Adres email: ");
                        out.write(s.getEmail());
                        out.println();
                        out.write("Miejscowość: ");
                        out.write(s.getMiasto());
                        out.println();
                        out.write("Ulica: ");
                        out.write(s.getUlica());
                        out.println();
                        out.write("Numer mieszkania: ");
                        out.write(s.getNrMieszkania());
                        out.println();
                        out.write("Kolegium: ");
                        out.write(s.getIdKolegium().getNazwa());
                        out.println();
                        out.write("Kierunek: ");
                        out.write(s.getIdKierunku().getNazwa());
                        out.println();
                        out.println();
                    }
                    out.close();
                    alert.setContentText("Zapisano do formatu TXT.");
                    alert.showAndWait();
                } catch (IOException e) {
                    alert.setContentText("Błąd zapisu formatu TXT.");
                    alert.showAndWait();
                }
            }

            if (comboZapiszS.getValue().equals("bin")) {//wybrany format bin
                try {
                    FileOutputStream plikobiektow = new FileOutputStream(fieldZapiszS.getText() + ".bin");
                    ObjectOutputStream strumienobiektow
                            = new ObjectOutputStream(plikobiektow);
                    strumienobiektow.writeObject(new ArrayList<Student>(studenci));
                    strumienobiektow.close();
                    alert.setContentText("Zapisano do formatu BIN.");
                    alert.showAndWait();
                } catch (IOException e) {
                    alert.setContentText("Błąd zapisu formatu BIN!");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Wczytuje dane do tabeli studentów z formatów XML i BIN.
     *
     * @param actionEvent
     */
    @FXML
    public void btnWczytajS(ActionEvent actionEvent) {
        try {
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR");

            if (fieldWczytajS.getText().equals("")) {
                alert.setContentText("Podaj nazwę pliku.");
                alert.showAndWait();
            }
            String nazwa = fieldWczytajS.getText();
            String format = comboWczytajS.getValue();

            if (format.equals("bin")) { //odczyt formatu binarnego
                try {
                    FileInputStream plikobiektow = new FileInputStream(nazwa + "." + format);
                    ObjectInputStream strumienobiektow = new ObjectInputStream(plikobiektow);

                    studenci.setAll((ArrayList<Student>) strumienobiektow.readObject());

                    alert.setContentText("Wczytano z formatu BIN.");
                    alert.showAndWait();

                } catch (Exception e) {
                    alert.setContentText("Błąd odczytu formatu BIN.");
                    alert.showAndWait();
                }
            }

            if (format.equals("xml")) {//odczyt formatu xml
                try {
                    // File selectedFile = fileChooser.showOpenDialog(primaryStage);
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(nazwa + "." + format);
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("Student");
                    studenci.removeAll();
                    tabelaStudenci.getItems().clear();//wyczyszczenie tabeli          

                    String idStudenta = "", kierunek = "", kolegium = "", imie = "", nazwisko = "", pesel = "", nrAlbumu = "", nrSemestru = "", nrTelefonu = "", email = "", miejscowosc = "", ulica = "", nrMieszkania = "";

                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        org.w3c.dom.Node nNode = nList.item(temp);

                        if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            idStudenta = eElement.getElementsByTagName("idStudenta").item(0).getTextContent();
                            kierunek = eElement.getElementsByTagName("kierunek").item(0).getTextContent();
                            kolegium = eElement.getElementsByTagName("kolegium").item(0).getTextContent();
                            imie = eElement.getElementsByTagName("imie").item(0).getTextContent();
                            nazwisko = eElement.getElementsByTagName("nazwisko").item(0).getTextContent();
                            pesel = eElement.getElementsByTagName("pesel").item(0).getTextContent();
                            nrAlbumu = eElement.getElementsByTagName("nrAlbumu").item(0).getTextContent();
                            nrSemestru = eElement.getElementsByTagName("nrSemestru").item(0).getTextContent();
                            nrTelefonu = eElement.getElementsByTagName("nrTelefonu").item(0).getTextContent();
                            email = eElement.getElementsByTagName("email").item(0).getTextContent();
                            miejscowosc = eElement.getElementsByTagName("miejscowosc").item(0).getTextContent();
                            ulica = eElement.getElementsByTagName("ulica").item(0).getTextContent();
                            nrMieszkania = eElement.getElementsByTagName("nrMieszkania").item(0).getTextContent();
                        }

                        Kierunek kie = kierunekMethods.wyszukajWgNazwy(kierunek);
                        Kolegium kol = kolegiumMethods.wyszukajWgNazwy(kolegium);
                        Student s = new Student(Integer.parseInt(idStudenta), kie, kol, imie, nazwisko, pesel, miejscowosc, ulica, nrMieszkania, nrTelefonu, email, nrSemestru, nrAlbumu);

                        studenci.add(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    alert.setContentText("Błąd odczytu formatu XML.");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
        }
    }

}
