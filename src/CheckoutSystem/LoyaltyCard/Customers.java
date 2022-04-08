package CheckoutSystem.LoyaltyCard;

public class Customers {
    private String name;
    private String username;
    private String Password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Customers(String name, String username, String Password){
        this.name=name;
        this.Password=Password;
        this.username=username;
    }

}
