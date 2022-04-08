package CheckoutSystem.LoyaltyCard;

import CheckoutSystem.Less8.checkoutController;
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
    public Label change;
    public Label changeLbl;


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
            FXMLLoader loader= new FXMLLoader(getClass().getResource("LoadingScreen.fxml"));
            Parent parent = loader.load();
            Stage stage= (Stage) PAY.getScene().getWindow();
            stage.setScene(new Scene(parent));

        }
    }
    public Button FinishBTN;
    public TextField cashTF;
    public Double message;


    public void finishPay(ActionEvent event) throws Exception {


        if (message < Double.parseDouble(cashTF.getText()) || message.equals(Double.parseDouble(cashTF.getText()))) {
            changeLbl.setVisible(true);
            change.setText(Double.toString(changereturn()));
            change.setVisible(true);

        } else if (message > Double.parseDouble(cashTF.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "the amount entered is not enough ", ButtonType.CLOSE);
            alert.showAndWait();
        } else if (cashTF.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING, "No Amount Entered", ButtonType.CLOSE);
            alert.showAndWait();

        }
        }
    public double changereturn(){
        double change= Double.parseDouble(cashTF.getText())-message;
        return change;
    }

    public Double datareciever(String passedinfo) {
        this.message = Double.parseDouble(passedinfo);
        return message;

    }
    }

