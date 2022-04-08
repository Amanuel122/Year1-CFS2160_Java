package week14.grade_table;

import java.util.ArrayList;
import java.util.Collections;

public class table {
    public ArrayList<Modules> module_list = new ArrayList<>();
public ArrayList<Double>numberList = new ArrayList<Double>();
    public table() {

    }

    public void addModuleinfo(Modules mod) {
        module_list.add(mod);
    }

    public double getTotalRaised() {
        double totalRaised = 0;
        for (Modules mod : module_list) {
            totalRaised += mod.getScore();

        }
        return totalRaised;
    }


    public String getmoduleinfo() {
        StringBuilder sb = new StringBuilder();
        for (Modules mod : module_list) {
            sb.append(String.format("%1s  %10s %10s", mod.getModule(), mod.getCode(), mod.getScore()));
            sb.append("\n");
            numberList.add(mod.getScore());
        }
        return sb.toString();

    }

    public void sortscore() {
        Collections.sort(module_list);
    }

    }
