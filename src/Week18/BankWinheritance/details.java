package Week18.BankWinheritance;

import java.text.NumberFormat;
import java.util.Locale;

abstract class details {
    public double deposit;
    public double withdraw;
    private String accountHolder;
    private String accountNumber;
    public double balance;
 public boolean hasOverD;
 public  double OverDleft;


    public details(String accountHolder, String accountNumber,double deposit,double withdraw) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;

        this.deposit= deposit;
        this.withdraw= withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public boolean isHasOverD() {
        return hasOverD;
    }

    public double getOverDleft() {
        return OverDleft;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String formatGBP(double amount) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }

    public boolean withdraw() {
        if (withdraw > 0 && hasOverD==true){
            this.balance -= withdraw;
            return true;
        }
        else if( hasOverD==false && balance>withdraw){
            balance-= withdraw;
            return true;
        }
        else return false;
    }
    public boolean deposit(){
        if (deposit>0) {
            this.balance += deposit;
            return true;

        }
        else {
            return false;
        }
    }
            public String display(){
        return "User: "+this.accountHolder + " \n" +"AccountNo: "+ this.accountNumber + "\n"+"balance: "+formatGBP(this.balance) +"\n";
    }
}
