package CheckoutSystem.CashOnly;

import CheckoutSystem.Products;
import CheckoutSystem.productList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;


public class CheckoutController extends productList {

    
    public CheckoutSystem.CashOnly.cart intoCART;
    @FXML
    private ListView<Products> foodListV;
    @FXML
    private ListView<Products> cart;
    public TextField totalTF;
    public TextField productsearchTF;

    @FXML
    public void initialize() {
        productListadd();
    intoCART = new cart();
    foodListV.setItems(listofItems);
    cart.setItems(intoCART);


    }


    public double getTotalRaised() {
        double totalRaised = 0;
        for (Products mod : intoCART) {
            totalRaised += mod.getPrice();


        }return totalRaised;
    }
    public void removeButton(ActionEvent event) {
        Products select = cart.getSelectionModel().getSelectedItem();

        if (select == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "select a product", ButtonType.OK);
            alert.showAndWait();
        } else {
            select.stockupdateadd();
            intoCART.remove(select);
            totalTF.setText(Double.toString(getTotalRaised()));
            totalTF.setEditable(false);
            foodListV.refresh();

            cart.getSelectionModel().clearSelection();
            System.out.println(select.getStock());
        }
    }

    public void addTC(ActionEvent event) {
     Products select = foodListV.getSelectionModel().getSelectedItem();
        if (select ==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "select a produce", ButtonType.OK);
            alert.showAndWait();
        } else if (select.getStock() < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Currently Out Of Stock", ButtonType.OK);
            alert.showAndWait();
        } else {
            intoCART.add(select);
            System.out.println("total"+totalTF.getText());
            totalTF.setText(Double.toString(Math.round(getTotalRaised()*100.0)/100.0));
            totalTF.setEditable(false);
            select.stockupdateminus();
            foodListV.getSelectionModel().clearSelection();
            System.out.println(select.getStock());

        }

    }
    public String formatGBP(double amount) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);}


    public void Search (ActionEvent event) {
        for (int i=0; i<listofItems.size();i++){
            if (productsearchTF.getText().equals(listofItems.get(i).getItem())){
                System.out.println(listofItems.get(i));
                System.out.println("found successfully for name");
                foodListV.getSelectionModel().select(i);

            }else if (productsearchTF.getText().equals(String.valueOf(listofItems.get(i).getId()))){
                  System.out.println(listofItems.get(i));
                  System.out.println("found successfully for id ");
                  foodListV.getSelectionModel().select(i);

            }
        }
    }
          
    public Button PAY;

    public void GoToPAY(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("Cash.fxml"));
         Parent parent = loader.load();
        CashController cashController=loader.getController();
        cashController.datareciever(totalTF.getText());

        Stage stage= (Stage) PAY.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }



}