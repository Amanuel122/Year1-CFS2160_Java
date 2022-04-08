package Week16.BankAccount;

import java.text.NumberFormat;
import java.util.Locale;

public class DepositAccount {  private String accountHolder;
    private String accountNumber;
    private double balance;
    private boolean hasOverdraft;
    private double deposit;
    private double withdraw;
    private double overdraftRemaining;




    public DepositAccount(String accountHolder, String accountNumber, double deposit, double withdraw) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.hasOverdraft = hasOverdraft;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.overdraftRemaining= overdraftRemaining;
    }

    public void setHasOverdraft(boolean hasOverdraft) {
        this.hasOverdraft = false;
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

    public boolean Interest(double amount){
        if (this.balance>0 ){
           double percent= amount/100;
            double t =this.balance*percent;
            this.balance+=t;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        if (hasOverdraft == true) {

            return "DEPOSIT BANK ACCOUNT" + '\n'+
                    "accountHolder= " + accountHolder + '\n' +
                    "AccountNumber= " + accountNumber + '\n' +
                    "Balance= " + formatGBP(balance) + '\n'+
                    "HasOverdraft= " + hasOverdraft + '\n'+
                    "OverdraftRemaining= " +formatGBP( overdraftRemaining) +
                    '}';
        }else return "DEPOSIT BANK ACCOUNT" + '\n'+
                "AccountHolder= " + accountHolder + '\n' +
                "AccountNumber= " + accountNumber + '\n' +
                "Balance=" + formatGBP(balance) ;

    }

    public static void main(String[] args) {
        DepositAccount f = new DepositAccount( "Tom Jones","2343424" , 25 ,15);
        f.deposit(f.getDeposit());
        f.withdraw(f.getWithdraw());
        f.overdraftRemaining();
        f.Interest(50);
        System.out.println(f);
    }
}
