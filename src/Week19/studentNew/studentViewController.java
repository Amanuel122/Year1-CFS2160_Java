package Week19.studentNew;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class studentViewController {
    public StudentList studentArray;
    public ListView<Students> StudentView;

    @FXML
    public void initialize() {
        // Initialise the list of staff with some test data
        studentArray = new StudentList();
        studentArray.addproducts(0, "carrot", "25 harborough drive, S21RJ", "computer science");

        // bind the list of aff to the staffList GUI component
        StudentView.setItems(studentArray);

    }
}
