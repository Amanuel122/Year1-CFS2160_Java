package CheckoutSystem.LoyaltyCard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginController {
    public TextField UsernameTF;
    public TextField PasswordTF;
    private CustomerDetails CustomerList;
    @FXML
    public Button LoginID;

    @FXML
    public void initialize(){
     CustomerList = new CustomerDetails();
     CustomerList.addDetails("Harry steven","Harry242","xm4d1");
     CustomerList.addDetails("Stanly hamish","stan786","st1an98");
    }
    public void LoginBTN(ActionEvent event) throws IOException {
        if (loginMatch() == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect Username and Password", ButtonType.OK);
            alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("checkout.fxml"));
            Parent parent = loader.load();
            Stage stage = (Stage) LoginID.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }

    }

    public  Boolean loginMatch() {
        for (int i=0; i<CustomerList.size();i++){
            if (UsernameTF.getText().equals(CustomerList.get(i).getUsername())&&PasswordTF.getText().equals(CustomerList.get(i).getPassword())){
                return true;
            }

        }return false;
}
}
