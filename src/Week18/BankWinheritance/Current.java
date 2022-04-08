package Week18.BankWinheritance;

import javax.print.DocFlavor;

public class Current extends details{

    public Current(String accountHolder, String accountNumber, double deposit, double withdraw) {
        super(accountHolder, accountNumber, deposit, withdraw);
        this.hasOverD = true;
        this.OverDleft=200;
    }
public boolean overdraftleft(){
    if (getBalance() < 0) {
        this.OverDleft+= getBalance();
        return true;
    } else return false;
}



    @Override
    public String display() {
        return super.display()+ "Overdraft: "+formatGBP(this.OverDleft);
    }
}


