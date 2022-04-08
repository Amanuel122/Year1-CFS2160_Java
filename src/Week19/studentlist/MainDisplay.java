package Week19.studentlist;

import Week19.demo3.Demo3;
import Week19.demo3.Employee;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainDisplay extends Application {

    private Employee emp;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button();
        button1.setText("Enter Details");
        button1.setOnAction(
                new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        addStudents popup = new addStudents(MainDisplay.this);
                        popup.initOwner(primaryStage);
                        popup.show();
                    }
                });

        Button button2 = new Button();
        button2.setText("Display Details");
        button2.setOnAction(
                new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Alert showOutputAlert = new Alert(Alert.AlertType.INFORMATION,
                                "Employee = " + emp, ButtonType.OK);
                        showOutputAlert.showAndWait();
                    }
                });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(button1,0,0);
        grid.add(button2,1,0);


        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("STUDENT INFO");
        primaryStage.show();

    }

    void setEmployee(String id, String fn, String sn, String dept) {
        emp = new Employee(id, fn, sn, dept);
    }
}
