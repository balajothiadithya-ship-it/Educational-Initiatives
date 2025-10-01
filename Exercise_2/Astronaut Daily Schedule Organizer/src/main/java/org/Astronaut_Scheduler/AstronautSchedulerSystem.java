package org.Astronaut_Scheduler;

import org.Astronaut_Scheduler.exceptions.InvalidTaskException;
import org.Astronaut_Scheduler.exceptions.TaskException;

import java.lang.reflect.Array;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Logger;
public class AstronautSchedulerSystem implements Observer
{
    private static final Logger logger = Logger.getLogger(AstronautSchedulerSystem.class.getName());
    AstronautSchedulerSystem(){
        SchedulerManager.getInstance().addObserver(this);
    }
 public Task parseAndCreateTask(String desc, String startTime, String endTime, String priority){
     try {
         if(!priority.equalsIgnoreCase("High") && !priority.equalsIgnoreCase("Low") && !priority.equalsIgnoreCase("Medium")){
             throw new InvalidTaskException("Task creation failed:Invalid priority");
         }

         if(!desc.matches("[a-zA-z ]+")){
             throw new InvalidTaskException("Task Creation failed:Description is invalid");
         }
         LocalTime start = LocalTime.parse(startTime);
         LocalTime end = LocalTime.parse(endTime);
         if (end.isBefore(start)) {
             throw new InvalidTaskException("Task Creation failed:End Time cannot be before start time");
         }
         return TaskFactory.createTask(desc, start, end, priority);
     }
     catch(DateTimeException exception){
         throw new InvalidTaskException("Task creation failed:"+"format should be in HH:mm and within 00:00 and 24:00");
     }

 }
public String executeCommand(String input){
    String[] parts = input.split("\\s+");
    String command = parts[0].toUpperCase();
    String result = "";
        try{
        switch (command) {
            case "ADD": {
                if (parts.length < 5) {
                    throw new InvalidTaskException("Wrong add command:Check input format once again");
                }
                String startTime = parts[parts.length - 3];
                String endTime = parts[parts.length - 2];
                String priority = parts[parts.length - 1];

                String desc = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length - 3));


                Task newTask = parseAndCreateTask(desc, startTime, endTime, priority);
                result = SchedulerManager.getInstance().addTask(newTask);
                logger.info(result);
                return result;
            }
            case "REMOVE": {
                if (parts.length < 2) {
                    throw new InvalidTaskException("Invalid Delete command,check your input");
                }
                result = SchedulerManager.getInstance().deleteTask(String.join(" ", Arrays.copyOfRange(parts, 1, parts.length)));
                logger.info(result);
                return result;
            }
            case "VIEW": {

                if (parts.length < 3) {
                    return SchedulerManager.getInstance().viewTask();
                } else if (parts.length == 3) {
                    String priority = parts[2];
                    return SchedulerManager.getInstance().viewTaskByPriority(priority);
                }
                else{
                    throw new InvalidTaskException("Invalid view command");
                }
            }
            case "EDIT": {
                int pipeIndex = -1;
                for (int ctr = 0; ctr < parts.length; ctr++) {
                    if (parts[ctr].equals("|")) {
                        pipeIndex = ctr;
                        break;
                    }
                }
                if (pipeIndex == -1 || parts.length < pipeIndex + 4) {
                    throw new InvalidTaskException("Wrong Edit Command");
                }

                String priority = parts[parts.length - 1];
                String endTime = parts[parts.length - 2];
                String startTime = parts[parts.length - 3];
                String oldDesc = String.join(" ", Arrays.copyOfRange(parts, 1, pipeIndex)).trim();
                String newDesc = String.join(" ", Arrays.copyOfRange(parts, pipeIndex + 1, parts.length - 3)).trim();

                Task editTask = parseAndCreateTask(newDesc, startTime, endTime, priority);
                result = SchedulerManager.getInstance().editTask(editTask, oldDesc);
                logger.info(result);
                return result;
            }
            default:
                throw new InvalidTaskException("Unknown command");

        }
    }
    catch(TaskException exception){
        logger.severe(exception.getMessage());
        return exception.getMessage();
    }

}
public String updateOnTask(TaskStatus status, Task... tasks){
    String msg = "";
    switch(status){

        case ADDED -> msg = "Task successfully added";
        case REMOVED -> msg = "Task successfully removed";
        case CONFLICT -> msg = "New Task "+tasks[0].getDesc()+" conflicts with "+tasks[1].getDesc();
        case EDITED -> msg = "Task edited Successfully";
    }
    return msg;
}
}
