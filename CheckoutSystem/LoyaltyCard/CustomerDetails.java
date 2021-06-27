package CheckoutSystem.LoyaltyCard;

import CheckoutSystem.Products;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

public class CustomerDetails extends ObservableListWrapper<Customers>{
    public CustomerDetails() {
        super(FXCollections.observableArrayList());

    }

    public void addDetails(String name, String username, String Password){
        super.add(new Customers( name, username, Password));
    }

}
