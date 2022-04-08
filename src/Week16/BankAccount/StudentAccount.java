package Week16.BankAccount;

import java.text.NumberFormat;
import java.util.Locale;

public class StudentAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private boolean hasOverdraft;
    private double deposit;
    private double withdraw;
    private double overdraftRemaining;


    public StudentAccount(String accountHolder, String accountNumber, double deposit, double withdraw, boolean hasOverdraft) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.hasOverdraft = hasOverdraft;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.overdraftRemaining = overdraftRemaining;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        if (!(this.balance >100)){return balance;}
            else return 0;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public String formatGBP(double amount) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }



    public boolean overdraftRemaining() {
        if (hasOverdraft == true && balance < 0) {
            this.overdraftRemaining = 500;
            this.overdraftRemaining += balance;
            return true;
        } else return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && hasOverdraft == true) {
            this.balance -= amount;
            return true;

        } else if (hasOverdraft == false && this.balance > amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean AddInterest(double amount) {
        if (amount > 0 && this.balance > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (hasOverdraft == true) {

            return "STUDENT BANK ACCOUNT" + '\n' +
                    "accountHolder= " + accountHolder + '\n' +
                    "AccountNumber= " + accountNumber + '\n' +
                    "Balance= " + formatGBP(balance) + '\n' +
                    "HasOverdraft= " + hasOverdraft + '\n' +
                    "OverdraftRemaining= " + formatGBP(overdraftRemaining) +
                    '}';
        } else return "STUDENT BANK ACCOUNT" + '\n' +
                "AccountHolder='" + accountHolder + '\n' +
                "AccountNumber='" + accountNumber + '\n' +
                "Balance=" + formatGBP(balance) +
                '}';

    }

}
