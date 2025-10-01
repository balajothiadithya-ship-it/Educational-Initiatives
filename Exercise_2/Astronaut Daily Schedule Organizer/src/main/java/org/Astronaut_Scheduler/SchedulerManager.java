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
    public String viewTaskByPriority(String priority){
        if(tasks.isEmpty()){
            return "No tasks scheduled for the day";
        }
        boolean flag = false;
        StringBuilder result = new StringBuilder("Tasks with "+priority+" are:\n");
        for(Task task:tasks){
            if(task.getPriority().equalsIgnoreCase(priority)){
                flag = true;
                result.append(task).append("\n");
            }
        }
        if(flag){
            return result.toString();
        }
        else{
            return "No task found under "+priority+" priority";
        }
    }
    public String editTask(Task newTask,String desc){
        Task taskToBeEdited = null;
        for(Task oldTask:tasks) {
            if (desc.equalsIgnoreCase(oldTask.getDesc())) {
                taskToBeEdited = oldTask;
                break;
            }
        }
        if(taskToBeEdited == null) {
            throw new TaskNotFound("Task Not Found");
        }
        for(Task task:tasks) {
            if (task.getDesc().equalsIgnoreCase(taskToBeEdited.getDesc())) {
                continue;
            } else {
                if(isConflict(newTask, task)){
                    String msg = notifyAllObservers(TaskStatus.CONFLICT, newTask, task);
                    throw new TaskConflictException(msg);
                }
            }
        }
                tasks.remove(taskToBeEdited);
                tasks.add(newTask);
                String msg = notifyAllObservers(TaskStatus.EDITED,taskToBeEdited);
                return msg;


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
