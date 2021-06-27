package CheckoutSystem.CashOnly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class CashController {
    public Button FinishBTN;
    public TextField cashTF;
    private Double message;
    public Label change;
    public Label changeLbl;



   //  long start = System.currentTimeMillis();
   //  long end = start + 10*1000;
   //  while (System.currentTimeMillis()<end){

     //}


   public void finishPay(ActionEvent event) throws IOException {

       if (message < Double.parseDouble(cashTF.getText()) || message.equals(Double.parseDouble(cashTF.getText()))) {
           changeLbl.setVisible(true);
           change.setText(Double.toString(changereturn()));
           change.setVisible(true);

       } else if (message > Double.parseDouble(cashTF.getText())) {
           Alert alert = new Alert(Alert.AlertType.WARNING, "the amount entered is not enough ", ButtonType.CLOSE);
           alert.showAndWait();
       } else if (cashTF.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.WARNING, "No Amount Entered", ButtonType.CLOSE);
           alert.showAndWait();

       }

   }
public double changereturn(){
       double change= Double.parseDouble(cashTF.getText())-message;
       return change;
}

  public Double datareciever(String passedinfo) {
       this.message = Double.parseDouble(passedinfo);
       return message;

    }


}