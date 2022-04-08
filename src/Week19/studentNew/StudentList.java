package Week19.studentNew;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

public class StudentList extends ObservableListWrapper<Students> {

    public StudentList() {
        super(FXCollections.observableArrayList());
    }

    public void addproducts(Integer ID, String Name, String Address, String Course){
        super.add(new Students(ID , Name, Address, Course));
    }
}

