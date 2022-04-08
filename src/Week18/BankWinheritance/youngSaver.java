package Week18.BankWinheritance;

public class youngSaver extends details{
    public youngSaver(String accountHolder, String accountNumber, double deposit, double withdraw) {
        super(accountHolder, accountNumber, deposit, withdraw);

    }



    @Override
    public boolean deposit() {
        if (deposit < 101 && balance + deposit < 101) {
            return super.deposit();

        } else {
            return false;
        }
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
