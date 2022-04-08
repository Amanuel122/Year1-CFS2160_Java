package Week18.BankWinheritance;

public class BankSummary {
    public static void main(String[] args) {
        Acounts ac= new Acounts();
        Current t= new Current("harry leneti","1298372",6,15);
        Deposit f = new Deposit("james stevenson","3875439",500, 245);
        student s = new student("mo salah","7286487",150,86);
        youngSaver y=new youngSaver("dak prescott","3895743",100,0);

        f.deposit();
        f.withdraw();
        f.Interest(3);

        t.deposit();
        t.withdraw();
        t.overdraftleft();

        s.deposit();
        s.withdraw();
        s.overdraftleft();


        y.deposit();
        y.withdraw();

        y.Interest(6);


        ac.addDetails(t);
        ac.addDetails(f);
        ac.addDetails(s);
        ac.addDetails(y);
        System.out.println(ac.pntAccounts());
        System.out.println( "total balance: "+ ac.formatGBP(ac.getTotalRaised()));
    }
}
