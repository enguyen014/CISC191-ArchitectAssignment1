package edu.sdccd.cisc191.template;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class StudentListGUI extends Application {
    private final int MAX_STUDENTS = 100;
    private final int NUM_FIELDS = 5;
    private final String[] FIELD_LABELS = {"ID", "First Name", "Last Name","Sport", "GPA"};
    private String[][] students = new String[MAX_STUDENTS][NUM_FIELDS];
    private int numStudents = 0;
    private BorderPane mainPane;
    private GridPane inputPane;
    private TableView<Students> table;
    private ObservableList<Students> studentData = FXCollections.observableArrayList();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student List");
        mainPane = new BorderPane();
        inputPane = new GridPane();
        table = new TableView<>();
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.setPadding(new Insets(10, 10, 10, 10));
        for (int i = 0; i < NUM_FIELDS; i++) {
            Label label = new Label(FIELD_LABELS[i] + ":");
            inputPane.add(label, 0, i);
            TextField field = new TextField();
            inputPane.add(field, 1, i);
        }
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addStudent());
        inputPane.add(addButton, 0, NUM_FIELDS);
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearFields());
        inputPane.add(clearButton, 1, NUM_FIELDS);
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> removeStudent());
        inputPane.add(removeButton, 2, NUM_FIELDS);

        TableColumn<Students, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Students, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Students, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Students, String> sportCol = new TableColumn<>("Sport");
        sportCol.setCellValueFactory(new PropertyValueFactory<>("sport"));
        TableColumn<Students, Double> gpaCol = new TableColumn<>("GPA");
        gpaCol.setCellValueFactory(new PropertyValueFactory<>("gpa"));
        table.getColumns().addAll(idCol, firstNameCol, lastNameCol, sportCol, gpaCol);
        table.setItems(studentData);
        mainPane.setLeft(inputPane);
        mainPane.setCenter(table);
        Scene scene = new Scene(mainPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create menu bar
        MenuBar menuBar = new MenuBar();
        mainPane.setTop(menuBar);

        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Create file menu items
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem saveAsItem = new MenuItem("Save As");
        MenuItem exitItem = new MenuItem("Exit");

        // Create edit menu items
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        // Create help menu items
        MenuItem aboutItem = new MenuItem("About");

        // Add menu items to menus
        fileMenu.getItems().addAll(newItem, openItem, saveItem, saveAsItem, new SeparatorMenuItem(), exitItem);
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);
        helpMenu.getItems().addAll(aboutItem);

        // Add menus to menu bar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        // Set action events for menu items
        exitItem.setOnAction(e -> System.exit(0));
        aboutItem.setOnAction(e -> showAboutDialog());

    }
    private void addStudent() {
        if (numStudents < MAX_STUDENTS) {
            String[] student = new String[NUM_FIELDS];
            for (int i = 0; i < NUM_FIELDS; i++) {
                TextField field = (TextField) inputPane.getChildren().get(i * 2 + 1);
                student[i] = field.getText();
            }
            if (student[3].equals("none")) {
                studentData.add(new normalStudent(student[0], student[1], student[2], Double.parseDouble(student[4])));
            } else {
                studentData.add(new AthleteStudent(student[0], student[1], student[2], student[3], Double.parseDouble(student[4])));
            }
            numStudents++;
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Maximum number of students reached.");
            alert.showAndWait();
        }
    }


    private void removeStudent() {
        Students student = table.getSelectionModel().getSelectedItem();
        if (student != null) {
            studentData.remove(student);
            numStudents--;
        }
    }
    private void clearFields() {
        for (int i = 0; i < NUM_FIELDS; i++) {
            TextField field = (TextField) inputPane.getChildren().get(i * 2 + 1);
            field.setText("");
        }
    }

    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student List GUI\nCreated by Duy Dao");
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}

