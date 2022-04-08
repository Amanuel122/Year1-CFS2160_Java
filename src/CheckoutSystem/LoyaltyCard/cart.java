package CheckoutSystem.LoyaltyCard;

import CheckoutSystem.Products;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

import java.text.NumberFormat;
import java.util.Locale;

public class cart extends ObservableListWrapper<Products>{

    public cart() {
        super(FXCollections.observableArrayList());
    }

    public String formatGBP(double amount){
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }

}



