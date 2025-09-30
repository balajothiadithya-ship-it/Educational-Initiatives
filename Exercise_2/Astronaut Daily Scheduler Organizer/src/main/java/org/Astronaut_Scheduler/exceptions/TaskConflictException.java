package org.Astronaut_Scheduler.exceptions;

public class TaskConflictException extends TaskException{
    public TaskConflictException(String msg){
        super(msg);
    }
}
