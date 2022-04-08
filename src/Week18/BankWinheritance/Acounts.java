package Week18.BankWinheritance;

import week14.grade_table.Modules;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Acounts  {
    private ArrayList<details>Detailinfo = new ArrayList<>();

    public Acounts(){}
    public void addDetails(details DETAILS){
        this.Detailinfo.add(DETAILS);
    }
    public String pntAccounts(){
        StringBuilder sb = new StringBuilder();
        for (details i:Detailinfo ){
            sb.append(i.display());
            sb.append("\n");
            sb.append("---------------------");
            sb.append("\n");
        }
        return sb.toString();
    }

    public String formatGBP(double amount) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }

    public double getTotalRaised() {
        double totalRaised = 0;
        for (details mod : Detailinfo) {
            totalRaised += mod.getBalance();

        }
        return totalRaised;
    }


}

