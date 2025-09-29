package org.Astronaut_Scheduler;

import java.time.LocalTime;

public class Task {
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
    public String toString(){
        return this.desc+" startTime:"+this.startTime+" endTime:"+this.endTime+" priority:"+this.priority;
    }
}
