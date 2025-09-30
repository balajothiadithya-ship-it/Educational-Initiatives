package org.Astronaut_Scheduler;

public interface Observer {
    public String updateOnTask(TaskStatus status, Task... tasks);
}
