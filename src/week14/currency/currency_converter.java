package week14.currency;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

// read user input
// covert to gbp
//output
// formattting
//
public class currency_converter {
    private double euroToGBPrate =0.88;



    public double euroToGBP (double amount){
        return this.euroToGBPrate * amount;
    }

public String formatGBP(double amount){
    NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
    return gb.format(amount);

}
public  String capturestring(){
    Scanner s = new Scanner(System.in); // this will save keyboard strokes
   // String i = s.nextLine(); // this will store the input from s into i when moved to the next line
    return s.nextLine();
}

    public static void main(String[] args) {
 currency_converter cc = new currency_converter(); // you can call on different projects by changing this ito the name of the project

        System.out.println("enter money in euros");
        String x = cc.capturestring();           // calls on the capture method above to give it an identifer
       double result = Double.parseDouble(x);   // this changes string into a double
        double gbp = cc.euroToGBP(result);    // this does the above calculation changing euro into £
        String s = cc.formatGBP(gbp);        // this changes any value into currency
        System.out.println(s);
    }
}
