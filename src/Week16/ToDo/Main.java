package Week16.ToDo;

public class Main {
    public static void main(String[] args) {
        Diary d = new Diary();
        job cfs2160 = new job("watch lecture     ", 5);
        d.addjobinfo(cfs2160);
        job cmf1234  = new job("complete tutorial ", 3);
        d.addjobinfo(cmf1234);
        job cmf2345  = new job("complete reading  ", 4);
        d.addjobinfo(cmf2345);
        job cmf3456  = new job("complete research ", 1);
        d.addjobinfo(cmf3456);
        job cmf4567  = new job("team meeting      ", 2);
        d.addjobinfo(cmf4567);
        System.out.println("---W16.Diary---");
        System.out.println(d.getjobinfo());

        System.out.println("---Certain String---");
        try {
            job t = d.searchDiary("complete research ");
            System.out.println(t);
        }catch (TNFexception j) {
            System.out.println(j.getMessage());
        }
        System.out.println("---Priority---");
        d.sortjobs();
        System.out.println(d.getjobinfo());

        System.out.println("---Remove completed tasks---");
        cmf1234.setCompleted(true);
        d.removeCompleted();
        System.out.println(d.getjobinfo());
    }
}
