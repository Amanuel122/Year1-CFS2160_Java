package CheckoutSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckoutOptionsController {
    public Button Cashonly;
    public Button CardOnly;
    public Button Less8BTN;
    public Button LoyaltyBTN;

    public void CO1Cash(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("CashOnly/checkout.fxml"));
        Parent parent = loader.load();
        Stage stage= (Stage) Cashonly.getScene().getWindow();
        stage.setScene(new Scene(parent,600,350));

    }


    public void CardBTn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CardOnly/checkout.fxml"));
        Parent parent = loader.load();
        Stage stage= (Stage) CardOnly.getScene().getWindow();
        stage.setScene(new Scene(parent,600,350));

    }

    public void Less8BTN(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Less8/checkout.fxml"));
        Parent parent = loader.load();
        Stage stage= (Stage) Less8BTN.getScene().getWindow();
        stage.setScene(new Scene(parent,600,350));
    }

    public void LoyatlyBTN(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("LoyaltyCard/Login.fxml"));
        Parent parent = loader.load();
        Stage stage= (Stage) LoyaltyBTN.getScene().getWindow();
        stage.setScene(new Scene(parent,600,350));
    }
}
