package week14;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class BankController {

    public TextField accountNumberTF;
    public TextField transactionAmountTF;
    public TextField balanceTF;
    private Account acc = new Account();

    public void getBalance(ActionEvent actionEvent) {

        String accountNumber = accountNumberTF.getText();

        if (accountNumber.equals(acc.getAccountNumber())) {
            balanceTF.setText("" + acc.getBalance());
        } else {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Account Error");
            accountAlert.setContentText("No such Account Number");
            accountAlert.setHeaderText("Account Number Invalid");
            accountAlert.showAndWait();
        }
    }

    public void depositMoney(ActionEvent actionEvent) {

        String accountNumber = accountNumberTF.getText();

        if (accountNumber.equals(acc.getAccountNumber())) {
            String amountString = transactionAmountTF.getText();
            try {
                double amount = Double.parseDouble(amountString);
                acc.deposit(amount);
                balanceTF.setText("" + acc.getBalance());
            } catch (NumberFormatException e) {
                Alert invalidNumberAlert = new Alert(Alert.AlertType.ERROR);
                invalidNumberAlert.setTitle("Transaction Error");
                invalidNumberAlert.setContentText("Invalid Transaction Value");
                invalidNumberAlert.setHeaderText("Transaction Value Not A Number");
                invalidNumberAlert.showAndWait();
            }
        } else {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Account Error");
            accountAlert.setContentText("No such Account Number");
            accountAlert.setHeaderText("Account Number Invalid");
            accountAlert.showAndWait();
        }
    }
}