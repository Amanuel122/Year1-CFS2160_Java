package CheckoutSystem;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import java.util.ArrayList;

public class productList extends ObservableListWrapper<Products> {
    public productList listofItems;

    public productList() {
        super(FXCollections.observableArrayList());
    }

    public void addproducts(Integer id, String item, Double price, int stock) {
        super.add(new Products(id, item, price, stock));
    }

    public void productListadd() {
        listofItems = new productList();
        listofItems.addproducts(278, "cheese", 0.67, 456);
        listofItems.addproducts(145, "carrot", 0.79, 2);
        listofItems.addproducts(179, "banana", 0.28, 79);
        listofItems.addproducts(912, "potato", 0.99, 120);
        listofItems.addproducts(973, "tuna", 1.85, 10);
        listofItems.addproducts(498, "bread", 2.42, 200);

    }
}


