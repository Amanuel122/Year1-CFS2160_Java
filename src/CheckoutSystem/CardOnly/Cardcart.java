package CheckoutSystem.CardOnly;

import CheckoutSystem.Products;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

import java.text.NumberFormat;
import java.util.Locale;

public class Cardcart extends ObservableListWrapper<Products>{

    public Cardcart() {
        super(FXCollections.observableArrayList());
    }

    public String formatGBP(double amount){
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }

}



