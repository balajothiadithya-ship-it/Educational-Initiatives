package org.Astronaut_Scheduler;

public class AstronautSchedulerSystem {
public void executeCommand(String input){
    String[] parts = input.split("\\s+");
    String command = parts[0];
    switch(command){
        case "ADD":
            String desc = parts[1];
            String startTime = parts[2];
            String endTime = parts[3];
            String priority = parts[4];
            Task newTask = TaskFactory.createTask(desc, startTime, endTime, priority);
            SchedulerManager.getInstance().addTask(newTask);
            break;
        case "REMOVE":
            SchedulerManager.getInstance().deleteTask(parts[1]);
            break;
        case "VIEW":
            SchedulerManager.getInstance().viewTask();
            break;

        default:
            System.out.println("unknown command");
    }

}
}
