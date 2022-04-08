package week14.currency;

import java.text.NumberFormat;
import java.util.*;

public class Sweets {
    public String formatGBP(double amount) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK); // this will change the number into currency
        return gb.format(amount);
    }


    public String capturestring() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static void main(String[] args) {
        ArrayList<Double> priceList = new ArrayList<Double>();

        Sweets price= new Sweets();

        int i = 0;
        do {
            System.out.println("Please enter sweet prices: ");
            String x = price.capturestring();
            if (x.length() > 2) {
                String s = x.substring(0, 2); // this will remove the p and only take the first 2 characters
                double d = Double.parseDouble(s);
                double e = d/100;
              //  String f = String.valueOf(e);  // this changes a double to a string
                priceList.add(e);
            } else {
                String s = x.substring(0, 1);
                double d = Double.parseDouble(s);
                double e = d/100;
               // String f = String.valueOf(e);
                priceList.add(e);
            }

                i++;
            } while (i < 5) ;  // while the i++ is adding one until it reaches 5 then the loop continues
        System.out.println(priceList);

        double sum=0;                            //this calculates the sum by going from 0 to 5 and adding them all
        for(int v=0;v< priceList.size();v++){
            sum = sum+ priceList.get(v);
        }
        double average = sum/priceList.size();
        System.out.println("The minimum value is:"+ price.formatGBP(Collections.min(priceList))); // the collection.min =min and max
        System.out.println("The maximin value is:"+ price.formatGBP(Collections.max(priceList)));
        System.out.println("the average value is:"+price.formatGBP(average));
        System.out.println("the sum value is:"+price.formatGBP(sum));
        }
    }


