package org.Astronaut_Scheduler;

public interface SchedulerSystem {
    public void addObserver(Observer observer);
    public String notifyAllObservers(TaskStatus status, Task... tasks);

}
