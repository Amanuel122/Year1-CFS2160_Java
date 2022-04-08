package Week19.studentlist;

public class studentInfo {private String ID;
    private String firstname;
    private String surname;
    private String course;

    public studentInfo(){
    }

    public studentInfo(String id, String fn, String sn, String cr){
        ID = id;
        firstname =fn;
        surname = sn;
        course = cr;
    }

    public String getID(){
        return ID;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getDepartment(){
        return course;
    }

    public void setDepartment(String department){
        this.course = department;
    }

    public String toString(){
        return ID + ": " + surname + ", " + firstname;
    }
}
