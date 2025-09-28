package org.Astronaut_Scheduler;

import java.util.ArrayList;
import java.util.List;
//Singleton and System class
public class SchedulerManager implements SchedulerSystem {
    private static SchedulerManager instance;
    private final List<Task> tasks;
    private final List<Astronaut> astronauts;
    private SchedulerManager(){
        tasks = new ArrayList<>();
        astronauts = new ArrayList<>();
    }
    public static SchedulerManager getInstance(){
        if(instance == null){
            instance = new SchedulerManager();
        }
        return instance;
    }

    @Override
    public void registerAstronaut(Astronaut astronaut) {

        astronauts.add(astronaut);
    }

    @Override
    public void notifyAllAstronauts() {
        for(Astronaut astronaut:astronauts){
            astronaut.updateOnTask();
        }

    }
    public void addTask(Task task){
        tasks.add(task);
        System.out.println("Task added successfully");
        notifyAllAstronauts();

    }
    public void deleteTask(Task task){
        tasks.remove(task);
        System.out.println("Task removed Successfully");
    }

}
