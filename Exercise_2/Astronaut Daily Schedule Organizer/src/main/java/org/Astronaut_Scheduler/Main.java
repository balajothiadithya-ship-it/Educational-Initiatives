package org.Astronaut_Scheduler;
import java.util.Scanner;
//Main class
public class Main {
    public static void main(String[] args) {
        AstronautSchedulerSystem system =  new AstronautSchedulerSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Astronaut Daily Schedule Organizer");
        System.out.println("Available Commands:");
        System.out.println("ADD <Task Description, startTime(HH:mm), endTime(HH:mm), priority>");
        System.out.println("VIEW tasks");
        System.out.println("Edit <Task Description> | <newDescription, startTime, endTime, priority>");
        System.out.println("Remove <Task Description>");
        System.out.println("EXIT");
        boolean running = true;
        while(running){
            System.out.print("> ");
            String input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("exit")){
                running = false;
            }
            else {
                String result = system.executeCommand(input);
                System.out.println(result);
            }

        }
        sc.close();
        System.out.println("Exiting Astronaut daily schedule organizer");
    }
}