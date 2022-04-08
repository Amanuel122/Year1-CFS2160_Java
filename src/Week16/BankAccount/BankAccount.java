package Week16.BankAccount;


public class BankAccount {
    //attributes of account here
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private boolean hasOverdraft;


    public BankAccount(String accountHolder, String accountNumber, boolean hasOverdraft) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.hasOverdraft = hasOverdraft;
    }

    public BankAccount(String accountHolder, String accountNumber, double balance, boolean hasOverdraft) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.hasOverdraft = hasOverdraft;
    }


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
        return "BankAccount{" +
                "accountHolder='" + accountHolder + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", hasOverdraft=" + hasOverdraft +
                '}';

    }

    public static void main(String[] args) {
        BankAccount f = new BankAccount("Tom Jones","775985453",true);
        f.setBalance(200.0);
        f.deposit(0.0);
        f.withdraw(300.0);
        f.AddInterest(5);
        System.out.println();
    }
}

