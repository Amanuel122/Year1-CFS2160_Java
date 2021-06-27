package CheckoutSystem;

import java.text.NumberFormat;
import java.util.Locale;

public class Products {
    private int id;
    private String item;
    private double price;
    private int stock;

    public Products(int id, String item, double price, int stock) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.stock = stock;
    }

    public String formatGBP(double amount) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return
                 id +":  "+
                 item +
                "      " + formatGBP(price)+"              "+ stock
                ;
    }
    public void stockupdateminus(){
        stock-=1;

    }
    public void stockupdateadd(){
        stock+=1;

    }
}

