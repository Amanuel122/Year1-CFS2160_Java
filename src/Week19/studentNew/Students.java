package Week19.studentNew;

import java.io.Serializable;

public class Students implements Serializable {
    private int ID;
    private String Name;
    private String Address;
    private String Course;

    public Students(int ID, String Name, String Address, String Course) {
        this.ID = ID;
        this.Name  = Name;
        this.Address = Address;
        this.Course = Course;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
