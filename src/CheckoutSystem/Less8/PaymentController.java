package CheckoutSystem.Less8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class PaymentController {
    @FXML
    public TextField AccountNTF;
    public TextField SortCodeTF;
    public DatePicker ExpiryTF;
    public TextField cvvTF;
    public Label CvvError;
    public Label AccountNumberError;
    public Label SortCodeError;


    List<String> bankAccounts = Arrays.asList("4823", "9878", "6858");
    public Button PAY;


    public String BankChecker() {
        String okay = AccountNTF.getText(0, 4);
        return okay;
    }

    public void PayBTN(ActionEvent event) throws IOException {
        AccountNTF.setText("4823123412341234");
        SortCodeTF.setText("123456");
        cvvTF.setText("122");
        if (cvvTF.getText().length() > 3 || cvvTF.getText().isEmpty()) {
            CvvError.setVisible(true);
        } else if (!(AccountNTF.getText().length() == 16) || AccountNTF.getText().isEmpty()) {
            AccountNumberError.setVisible(true);
        } else if (!(SortCodeTF.getText().length() == 6) || SortCodeTF.getText().isEmpty()) {
            SortCodeError.setVisible(true);
            System.out.println(BankChecker());
        } else if (!(bankAccounts.contains(BankChecker()))) {
            Alert Alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR, "Bank Account not Found\n please try again", ButtonType.CLOSE);
            Alert.showAndWait();
        } else {
            Window ThankYouPage = PAY.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("LoadingScreen.fxml"));
            ThankYouPage.getScene().setRoot(newRoot);

        }
    }
    public Button FinishBTN;
    public TextField cashTF;
    checkoutController done=new checkoutController();
    // checkoutController tt =new checkoutController();


    /** public  String changecalculator(){
     int total =Integer.parseInt(t.totalTF.getText());
     int cash= Integer.parseInt(cashTF.getText());
     t=new checkoutController();
     Integer change = total-cash;

     return change.toString();
     }*/

    public void finishPay(ActionEvent event) throws Exception {

        System.out.println("total that is "+done.findtotal());
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
