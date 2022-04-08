package CheckoutSystem.Less8;


import CheckoutSystem.Products;
import CheckoutSystem.productList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;


public class checkoutController extends productList {

  
    public CheckoutSystem.Less8.cart intoCART;
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
    public String findtotal(){
      String tt= this.totalTF.getText();
      return tt;
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

        System.out.println(listofItems);
     Products select = foodListV.getSelectionModel().getSelectedItem();
        if (select ==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "select a produce", ButtonType.OK);
            alert.showAndWait();
        } else if (select.getStock() < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Currently Out Of Stock", ButtonType.OK);
            alert.showAndWait();
        }else if (intoCART.size()>=8){
            Alert alert = new Alert(Alert.AlertType.WARNING, "This checkout is only for less than 8 items", ButtonType.OK);
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




    public Button PAY;

    public void GoToPAY(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Payment.fxml"));
        Parent parent = loader.load();
        Stage stage= (Stage) PAY.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }



}