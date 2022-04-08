package Week16.BankAccount;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.geom.Arc2D;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrentAccount {    private String accountHolder;
    private String accountNumber;
    private double balance;
    private boolean hasOverdraft;
    private double deposit;
    private double withdraw;
    private double overdraftRemaining;




    public CurrentAccount(String accountHolder, String accountNumber, double deposit, double withdraw,boolean hasOverdraft) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.hasOverdraft = hasOverdraft;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.overdraftRemaining= overdraftRemaining;
    }

    public double getWithdraw() { return withdraw; }

    public double getDeposit() { return deposit; }

    public void setDeposit(double deposit) { this.deposit = deposit; }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount){
        if (amount>0) {
            this.balance += amount;
            return true;
        }
        else {
            return false;
        }
    }
    public String formatGBP(double amount){
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);}
    double  overD=500;
    public boolean overdraftRemaining(){
        if ( hasOverdraft==true && balance<0){
            this.overdraftRemaining = 500;
            this.overdraftRemaining+=balance;
            return true;
        }
        else return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && hasOverdraft == true) {
            this.balance -= amount;
            return true;

        }
        else if (hasOverdraft == false && this.balance > amount) {
            this.balance -= amount;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean AddInterest(double amount){
        if (amount>0 && this.balance>0){
            this.balance+=amount;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        if (hasOverdraft == true) {

            return "CURRENT ACCOUNT" + '\n'+
                    "accountHolder= " + accountHolder + '\n' +
                    "AccountNumber= " + accountNumber + '\n' +
                    "Balance= " + formatGBP(balance) + '\n'+
                    "HasOverdraft= " + hasOverdraft + '\n'+
                    "OverdraftRemaining= " +formatGBP( overdraftRemaining) +
                    '}';
        }else return "CURRENT ACCOUNT" + '\n'+
                "AccountHolder= " + accountHolder + '\n' +
                "AccountNumber= " + accountNumber + '\n' +
                "Balance=" + formatGBP(balance) +
                '}';

    }

    public static void main(String[] args) {
        CurrentAccount f = new CurrentAccount ( "Tom Jones","2343424" , 24.4 ,355,false);
        f.deposit(f.getDeposit());
        f.withdraw(f.getWithdraw());
        f.overdraftRemaining();
        System.out.println(f);
    }
}
