package org.Astronaut_Scheduler;
//Factory class

import java.time.DateTimeException;
import java.time.LocalTime;

public class TaskFactory {
    public static Task createTask(String desc, LocalTime startTime, LocalTime endTime, String priority) {
        return new Task(desc, startTime, endTime, priority);
    }
}
