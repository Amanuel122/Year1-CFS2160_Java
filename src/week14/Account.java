package week14;


public class Account {

    private String accountNumber;
    private double balance;


    public Account() {
        accountNumber = "0001";
        balance = 0.0;
    }


    public Account(String acNo) {
        accountNumber = acNo;
        balance = 0.0;
    }


    public void deposit(double amt) {
        balance += amt;
    }


    public void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public double getBalance() {
        return balance;
    }

}