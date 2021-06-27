package CheckoutSystem.CardOnly;


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


    public Cardcart intoCART;
    @FXML
    private ListView<Products> foodListV;
    @FXML
    private ListView<Products> cart;
    public TextField totalTF;
    public TextField productsearchTF;

    @FXML
    public void initialize() {
    productListadd();
    intoCART = new Cardcart();

    foodListV.setItems(listofItems);
    cart.setItems(intoCART);


    }

    public TextField getTotalTF() {
        return totalTF;
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
            totalTF.setText(Double.toString(getTotalRaised()));
            totalTF.setEditable(false);
            select.stockupdateminus();
            foodListV.getSelectionModel().clearSelection();
            System.out.println(select.getStock());

        }

    }



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
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Payment.fxml"));
        Parent parent = loader.load();
        Stage stage= (Stage) PAY.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }



}