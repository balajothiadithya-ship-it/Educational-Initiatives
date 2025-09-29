package org.Astronaut_Scheduler;
//Factory class

import java.time.LocalTime;

public class TaskFactory {
    public static Task createTask(String desc, String startTime, String endTime, String priority){
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        return new Task(desc, start, end, priority);

    }
}
