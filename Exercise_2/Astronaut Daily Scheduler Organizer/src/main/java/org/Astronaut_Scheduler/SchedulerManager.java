package org.Astronaut_Scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Singleton and System class
public class SchedulerManager implements SchedulerSystem {
    private static SchedulerManager instance;
    private final List<Task> tasks;
    private final List<Astronaut> astronauts;

    private SchedulerManager() {
        tasks = new ArrayList<>();
        astronauts = new ArrayList<>();
    }

    public static SchedulerManager getInstance() {
        if (instance == null) {
            instance = new SchedulerManager();
        }
        return instance;
    }

    @Override
    public void registerAstronaut(Astronaut astronaut) {

        astronauts.add(astronaut);
    }

    @Override
    public void notifyAllAstronauts(TaskStatus status, Task task) {
        for (Astronaut astronaut : astronauts) {

            astronaut.updateOnTask(status, task);
        }

    }

    private boolean isConflict(Task newTask, Task existingTask) {
        return newTask.getStartTime().isBefore(existingTask.getEndTime()) && newTask.getEndTime().isAfter(existingTask.getStartTime());
    }

    public void addTask(Task newTask) {
        for (Task existingTask : tasks) {
            if (isConflict(newTask, existingTask)) {
                System.out.println("The new Task conflicts with existing task " + existingTask.getDesc());
                return;
            }
        }
        tasks.add(newTask);
        System.out.println("Task added successfully");
        notifyAllAstronauts(TaskStatus.ADDED, newTask);

    }
    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("No Tasks scheduled for the day");
        }
        else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
    public void deleteTask(String desc) {
        var iterator = tasks.iterator();
        while(iterator.hasNext()) {
            Task task = iterator.next();
            if(task.getDesc().equalsIgnoreCase(desc)) {
                iterator.remove();
                System.out.println("Task removed Successfully");
                notifyAllAstronauts(TaskStatus.REMOVED, task);
                return;
            }
        }
            System.out.println("Task not found");



    }
}
