package org.Astronaut_Scheduler;

import java.time.LocalTime;
import java.util.Objects;

public class Task implements Comparable<Task>{
    private String desc;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    public Task(String desc, LocalTime startTime, LocalTime endTime, String priority){
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public int compareTo(Task other){
        int cmp = this.startTime.compareTo(other.startTime);
        if(cmp != 0){
            return cmp;
        }
        else{
            return this.endTime.compareTo(other.endTime);
        }
    }
    public boolean equals(Object o) {
        if (this == o) return true;                  // same reference
        if (o == null || getClass() != o.getClass()) return false; // null or different class
        Task task = (Task) o;
        return Objects.equals(desc, task.desc) &&
                Objects.equals(startTime, task.startTime) &&
                Objects.equals(endTime, task.endTime) &&
                Objects.equals(priority, task.priority);
    }
    @Override
    public int hashCode() {
        return Objects.hash(desc, startTime, endTime);
    }
    public String toString(){
        return this.desc+" startTime:"+this.startTime+" endTime:"+this.endTime+" priority:"+this.priority;
    }
}
