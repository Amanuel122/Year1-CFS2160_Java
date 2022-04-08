package Week16.ToDo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Diary {
    public ArrayList<job> DiaryCollection = new ArrayList<>();


    public Diary() {
    }


    public void addjobinfo(job j) {
        DiaryCollection.add(j);
    }

    public String getjobinfo() {
        StringBuilder sb = new StringBuilder();
        for (job j : DiaryCollection) {
            sb.append(j);
            sb.append("\n");

        }
        return sb.toString();
    }
    public job searchDiary (String search) throws TNFexception { // this links to TNF to so that if the value is not found it will print an error
        for (job j : DiaryCollection) {
            if ((j.getDescription().contains(search))) {
                return j;
            }
        }
throw new TNFexception("task not found");
    }
    public void sortjobs(){
        Collections.sort(DiaryCollection);
    }
    public void removeCompleted(){               // this removes the completed tasks
        Iterator<job>rc = DiaryCollection.iterator();
        while (rc.hasNext()){
            job c = rc.next();
            if(c.isCompleted()){
                rc.remove();
            }
        }
    }


}

