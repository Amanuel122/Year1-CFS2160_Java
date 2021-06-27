package CheckoutSystem.CashOnly;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ThankYouPage extends CashController {
    public TextField changeReturnTF;
    private Double info;
    private Double moneyinput;



    public void totalpassed(Double passedinfo) {
        this.info = passedinfo;

    }
    public void moneyinput(Double passedinfo){
        this.moneyinput=passedinfo;
    }
    public void changeReturn(){

        Double change=info-moneyinput;
        changeReturnTF.setText(String.valueOf(change));
        changeReturnTF.setEditable(false);
    }
}
