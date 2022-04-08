package Week16.ToDo;

public class job implements Comparable<job>{
    public String Description;
    public int priority;
    public boolean completed;


    public job( String Description, int priority){
        this.Description = Description;
        this.priority=priority;
        this.completed=false;

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format("Description: %-4s | Priority:%2d | Completed:%2s", this.Description,this.priority,this.completed);
    }

    @Override
    public int compareTo(job j) {
       int priority =Integer.compare(j.getPriority(),this.getPriority());
       if(priority ==0){
           priority = this.getDescription().compareTo(j.getDescription());
        }
       return priority;
    }
}
