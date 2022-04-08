package week14.grade_table;

import javax.print.DocFlavor;
import java.util.Collections;

public class Modules  implements Comparable<Modules> {
    public String code;
    private String module;
    public double score;

    public Modules(String module, String code, double score) {
        this.module = module;
        this.code = code;
        this.score = score;
    }


    public String getCode() {
        return code;
    }

    public String getModule() {
        return module;
    }

    public double getScore() {
        return score;
    }
@Override
public String toString(){
        return module +"\""+","+code+","+score;
}

    @Override
    public int compareTo(Modules mod) {
        if (mod.getScore() > this.getScore()) {
            return 1;
        } else if (mod.getScore() < this.getScore()) {
            return -1;
        } else {
            return 0;
        }
    }


    }





