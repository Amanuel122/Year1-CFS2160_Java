package Week17.staffList;

import Week17.staffList.StaffList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StaffListController {
    @FXML
    public TextField idTF;
    @FXML
    public TextField firstnameTF;
    @FXML
    public TextField surnameTF;
    @FXML
    public TextField departmentTF;

    private StaffList listOfStaff;
    @FXML
    private ListView<Employee> staffList;

    @FXML
    public void initialize() {
        // Initialise the list of staff with some test data
        listOfStaff = new StaffList();
        listOfStaff.addEmployee("S001", "Gary", "Allen", "CompSci");
        listOfStaff.addEmployee("S002", "Hugh", "Osborne", "CompSci");
        listOfStaff.addEmployee("S003", "Diane", "Kitchen", "CompSci");
        listOfStaff.addEmployee("S004", "Simon", "Parkinson", "CompSci");
        listOfStaff.addEmployee("S005", "Mauro", "Vallati", "CompSci");

        // bind the list of staff to the staffList GUI component
        staffList.setItems(listOfStaff);
    }

    @FXML
    private void staffListSelectionMade() {
        Employee selectedEmp = staffList.getSelectionModel().getSelectedItem();
        if (selectedEmp != null) {
            setAllTextFields(selectedEmp);
        }
    }

    @FXML
    private void addButtonPressed() {
        String newID = idTF.getText();
        String newSurname = surnameTF.getText();
        String newFirstname = firstnameTF.getText();
        String newDept = departmentTF.getText();

        if (newID.equals("") || newSurname.equals("") ||
                newFirstname.equals("") || newDept.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Enter Full Details", ButtonType.OK);
            alert.showAndWait();
        } else {
            listOfStaff.addEmployee(newID, newFirstname, newSurname, newDept);
            Employee newEmp = listOfStaff.findEmployeeByID(newID);
            staffList.getSelectionModel().select(newEmp);
            staffList.scrollTo(newEmp);
            setAllTextFields(newEmp);
        }
    }

    @FXML
    private void removeButtonPressed() {
        int selectedIndex = staffList.getSelectionModel().getSelectedIndex();

        if (selectedIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Select an Employee", ButtonType.OK);
            alert.showAndWait();
        } else {
            Employee toGo = staffList.getItems().get(selectedIndex);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + toGo + " ?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                listOfStaff.removeEmployee(toGo.getID());
                clearAllTextFields();
                staffList.getSelectionModel().clearSelection();
            }
        }
    }

    @FXML
    private void clearButtonPressed() {
        clearAllTextFields();
        staffList.getSelectionModel().clearSelection();
    }

    @FXML
    private void findButtonPressed() {
        Employee searchedFor;
        String findID = idTF.getText();
        String findName = surnameTF.getText();

        if (findID.equals("") && findName.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Enter an ID or a Surname", ButtonType.OK);
            alert.showAndWait();
        } else {
            if (!findID.equals("")) {
                searchedFor = listOfStaff.findEmployeeByID(findID);
            } else {
                searchedFor = listOfStaff.findEmployeeByName(findName);
            }

            if (searchedFor == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Employee Not Found", ButtonType.OK);
                alert.showAndWait();
            } else {
                staffList.getSelectionModel().select(searchedFor);
                staffList.scrollTo(searchedFor);
                setAllTextFields(searchedFor);
            }
        }
    }

    private void clearAllTextFields() {
        idTF.setText("");
        firstnameTF.setText("");
        surnameTF.setText("");
        departmentTF.setText("");
    }

    private void setAllTextFields(Employee e){
        idTF.setText(e.getID());
        firstnameTF.setText(e.getFirstname());
        surnameTF.setText(e.getSurname());
        departmentTF.setText(e.getDepartment());
    }
}
