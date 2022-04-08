package week14.grade_table;

import java.util.ArrayList;
import java.util.Collections;

public class details {
    public static void main(String[] args) {
        table t = new table();
        System.out.println("Modules                                       "+ "code        "    +"grade");
        System.out.println("__________________________________________");
        t.addModuleinfo(new Modules("Computer network fundamentals            ","CFS2160",56));
        t.addModuleinfo(new Modules("Computer Design and Software Developement","CFS2160",85));
    t.addModuleinfo(new Modules("Project 1                                ","CFM2898",44));
        t.sortscore();

        System.out.println(t.getmoduleinfo());

        System.out.println("Modules "+ t.module_list.size());
        System.out.println("average grade     "+t.getTotalRaised()/t.module_list.size());
        System.out.println("Highest grade     "+Collections.max(t.numberList));
        System.out.println("Lowest Grade      "+Collections.min(t.numberList));
    }

}
