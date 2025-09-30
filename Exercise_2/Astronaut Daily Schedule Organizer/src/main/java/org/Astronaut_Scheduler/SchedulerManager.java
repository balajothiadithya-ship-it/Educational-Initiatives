package org.Astronaut_Scheduler;

import org.Astronaut_Scheduler.exceptions.TaskConflictException;
import org.Astronaut_Scheduler.exceptions.TaskExistException;
import org.Astronaut_Scheduler.exceptions.TaskNotFound;

import java.util.*;

//Singleton and System class
public class SchedulerManager implements SchedulerSystem {
    private static SchedulerManager instance;
    private final Set<Task> tasks;
    private final List<Observer> observers;

    private SchedulerManager() {
        tasks = new TreeSet<>();
        observers = new ArrayList<>();

    }

    public static SchedulerManager getInstance() {
        if (instance == null) {
            instance = new SchedulerManager();
        }
        return instance;
    }

    @Override
    public void addObserver(Observer observer) {

        observers.add(observer);
    }

    @Override
    public String notifyAllObservers(TaskStatus status, Task... tasks) {
        StringBuilder builder = new StringBuilder("");
        for (Observer observer : observers) {

            builder.append(observer.updateOnTask(status, tasks));
        }
        return builder.toString();
    }

    private boolean isConflict(Task newTask, Task existingTask) {
        return newTask.getStartTime().isBefore(existingTask.getEndTime()) && newTask.getEndTime().isAfter(existingTask.getStartTime());
    }

    public String addTask(Task newTask) {
        for(Task existingTask:tasks){
            if(existingTask.getDesc().equalsIgnoreCase(newTask.getDesc())){
                throw new TaskExistException("task already exists");
            }
        }
        for (Task existingTask : tasks) {
            if (isConflict(newTask, existingTask)) {
                String msg = notifyAllObservers(TaskStatus.CONFLICT, newTask, existingTask);
                throw new TaskConflictException(msg);
            }
        }

        tasks.add(newTask);
        String msg = "";
        msg = notifyAllObservers(TaskStatus.ADDED, newTask);
        return msg;

    }
    public String viewTask(){
        if(tasks.isEmpty()){
            return "No Tasks scheduled for the day";
        }
        else {
            StringBuilder result = new StringBuilder("Scheduled Tasks:\n");
            for (Task task : tasks) {
                result.append(task).append("\n");
            }
            return result.toString();
        }
    }
    public String deleteTask(String desc) {
        Iterator<Task> it = tasks.iterator();
        String msg = "";
        while(it.hasNext()) {
            Task task = it.next();
            if(task.getDesc().equalsIgnoreCase(desc)) {
                it.remove();

                msg = notifyAllObservers(TaskStatus.REMOVED, task);

                return msg;
            }
        }
            throw new TaskNotFound("Task not found");
    }
}
