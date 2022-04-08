package Week16.BankAccount;

public class main {
    public static void main(String[] args) {
        CurrentAccount f = new CurrentAccount ( "Tom Jones","2343424" , 24.4 ,355,false);
        f.deposit(f.getDeposit());
        f.withdraw(f.getWithdraw());
        f.overdraftRemaining();
        System.out.println(f);

        System.out.println("-----------------------");

        StudentAccount T = new StudentAccount( "Tom Jones","2343424" , 24.4 ,355,true);
        T.deposit(T.getDeposit());
        T.withdraw(T.getWithdraw());
        T.overdraftRemaining();
        System.out.println(T);

        System.out.println("-----------------------");

       DepositAccount J = new DepositAccount( "Tom Jones","2343424" , 25 ,15);
        J.deposit(f.getDeposit());
        J.withdraw(f.getWithdraw());
        J.overdraftRemaining();
        J.Interest(50);
        System.out.println(J);

        System.out.println("-----------------------");

        YoungSaverAccount M = new YoungSaverAccount( "Tom Jones","2343424" , 30 ,15);
        M.deposit(f.getDeposit());
        M.withdraw(f.getWithdraw());
        M.overdraftRemaining();
        M.Interest(50);
        M.balancelimit(f.getBalance());
        System.out.println(M);
    }
}
