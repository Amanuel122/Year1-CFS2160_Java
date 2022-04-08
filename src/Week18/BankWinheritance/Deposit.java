package Week18.BankWinheritance;

public class Deposit extends details{

    public Deposit(String accountHolder, String accountNumber, double deposit, double withdraw) {
        super(accountHolder, accountNumber, deposit, withdraw);

    }

    public boolean Interest(double percentage){
        if (balance>0 ){
            double percent= percentage/100;
            double t =balance*percent;
            balance+=t;
            return true;
        }
        else{
            return false;
        }
    }


        @Override
        public String display() {
            return super.display();
        }
    }


