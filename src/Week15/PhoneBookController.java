package Week15;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PhoneBookController {public TextField nameTF;
    public TextField numberTF;
    public ComboBox phoneBookFromCombo;
    public ComboBox phoneBookToCombo;

    PhoneBook Family = new PhoneBook();
    PhoneBook Friends = new PhoneBook();
    PhoneBook Work = new PhoneBook();

    @FXML
    private void initialize()
    {
        phoneBookFromCombo.getItems().addAll("Family", "Friends", "Work");
        phoneBookFromCombo.getSelectionModel().select("Family");
        phoneBookToCombo.getItems().addAll("Family", "Friends", "Work");
        phoneBookToCombo.getSelectionModel().select("Friends");
    }

    private PhoneBook selectPhoneBook(String phoneBookName){
        PhoneBook tmpPhoneBook = null;

        // Look up available phone books
        if (phoneBookName.equals("Family")) {
            tmpPhoneBook = Family;
        } else if (phoneBookName.equals("Friends")) {
            tmpPhoneBook = Friends;
        } else if (phoneBookName.equals("Work")) {
            tmpPhoneBook = Work;
            // No phone book matched
        } else {
            // Show error
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Phone Book Error");
            accountAlert.setContentText("No such phone book");
            accountAlert.setHeaderText("Phone Book Invalid");
            accountAlert.showAndWait();
        }

        return tmpPhoneBook;
    }

    public void getNumber(ActionEvent actionEvent) {
        String phoneBooktxt = (String) phoneBookFromCombo.getValue();
        PhoneBook tmpPhoneBook = selectPhoneBook(phoneBooktxt);

        // Check if a phone book was found
        if(tmpPhoneBook != null) {
            String number = tmpPhoneBook.getNumber(nameTF.getText());

            // Check if an entry exists
            if(number != null) {
                numberTF.setText(number);
            }
            else {
                // Reset Text Fields
                nameTF.setText("");
                numberTF.setText("");

                // Show error
                Alert accountAlert = new Alert(Alert.AlertType.ERROR);
                accountAlert.setTitle("Phone Book Error");
                accountAlert.setContentText("Given name is not phone book");
                accountAlert.setHeaderText("Name Invalid");
                accountAlert.showAndWait();
            }
        }
    }

    public void addNewEntry(ActionEvent actionEvent) {
        String phoneBooktxt = (String) phoneBookFromCombo.getValue();
        PhoneBook tmpPhoneBook = selectPhoneBook(phoneBooktxt);

        // Check if a phone book was found
        if(tmpPhoneBook != null) {
            String name = nameTF.getText();
            String number = numberTF.getText();

            // Check if a name and number were provided
            if(!name.isEmpty() && !number.isEmpty()) {
                tmpPhoneBook.addNewEntry(name, number);

                // Confirm entry
                Alert accountAlert = new Alert(Alert.AlertType.INFORMATION);
                accountAlert.setTitle("New Entry Confirmation");
                accountAlert.setContentText("New entry added to phone book");
                accountAlert.setHeaderText("Entry Added successfully");
                accountAlert.showAndWait();
            } else {
                //Show Error
                Alert accountAlert = new Alert(Alert.AlertType.ERROR);
                accountAlert.setTitle("Phone Book Error");
                accountAlert.setContentText("New entry was not added to phone book");
                accountAlert.setHeaderText("Name or Number Invalid");
                accountAlert.showAndWait();
            }
        }
    }

    public void transferNumber(ActionEvent actionEvent) {
        String phoneBookFromtxt = (String) phoneBookFromCombo.getValue();
        PhoneBook tmpPhoneBookFrom = selectPhoneBook(phoneBookFromtxt);

        String phoneBookTotxt = (String) phoneBookToCombo.getValue();
        PhoneBook tmpPhoneBookTo = selectPhoneBook(phoneBookTotxt);

        // Check if a phone book was found
        if (tmpPhoneBookFrom != null && tmpPhoneBookTo != null){
            // Check if different phone books were provided
            if (tmpPhoneBookFrom != tmpPhoneBookTo) {
                String name = nameTF.getText();
                String number = tmpPhoneBookFrom.getNumber(name);
                // Check if an entry exists
                if (number != null) {
                    numberTF.setText(number);
                    tmpPhoneBookTo.addNewEntry(name, number);

                    // Confirm transfer
                    Alert accountAlert = new Alert(Alert.AlertType.INFORMATION);
                    accountAlert.setTitle("Transfer Confirmation");
                    accountAlert.setContentText("New entry added to phone book");
                    accountAlert.setHeaderText("Entry Transferred Successfully");
                    accountAlert.showAndWait();
                } else {
                    // Show error
                    Alert accountAlert = new Alert(Alert.AlertType.ERROR);
                    accountAlert.setTitle("Phone Book Error");
                    accountAlert.setContentText("Entry was not transferred to phone book");
                    accountAlert.setHeaderText("Name Invalid");
                    accountAlert.showAndWait();
                }
            } else {
                // Show error
                Alert accountAlert = new Alert(Alert.AlertType.ERROR);
                accountAlert.setTitle("Phone Book Error");
                accountAlert.setContentText("Cannot transfer an entry from and to the same phone book");
                accountAlert.setHeaderText("From and To Phone Book are Identical");
                accountAlert.showAndWait();
            }
        }
    }
}
