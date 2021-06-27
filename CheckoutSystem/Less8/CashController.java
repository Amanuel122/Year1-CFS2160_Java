package CheckoutSystem.Less8;

import CheckoutSystem.CashOnly.CheckoutController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CashController {
    public Button FinishBTN;
    public TextField cashTF;
    CheckoutController done=new CheckoutController();
   // checkoutController tt =new checkoutController();


   public void finishPay(ActionEvent event) throws Exception {

        if (Integer.parseInt("33")>Integer.parseInt(cashTF.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING,"the amount entered is not enough", ButtonType.CLOSE);
        alert.showAndWait();
        }else if(cashTF.getText()==""){
            Alert alert = new Alert(Alert.AlertType.WARNING,"No Amount Entered", ButtonType.CLOSE);
            alert.showAndWait();
        }else{

            FXMLLoader loader= new FXMLLoader(getClass().getResource("ThankYOU.fxml"));
            Parent parent = loader.load();
            Stage stage= (Stage) FinishBTN.getScene().getWindow();
            stage.setScene(new Scene(parent));
          }

   }
}