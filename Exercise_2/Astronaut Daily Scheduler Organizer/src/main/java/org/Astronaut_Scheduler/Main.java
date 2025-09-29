package org.Astronaut_Scheduler;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AstronautSchedulerSystem system =  new AstronautSchedulerSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Astronaut Daily Schedule Organizer");
        System.out.println("Available Commands:");
        System.out.println("ADD task <Description, startTime(HH:mm), endTime(HH:mm), priority>");
        System.out.println("REMOVE task <Description>");
        System.out.println("VIEW tasks");
        System.out.println("EXIT");
        while(true){
            System.out.print("> ");
            String input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
            system.executeCommand(input);

        }
        sc.close();
        System.out.println("Exiting Astronaut daily schedule organizer");
    }
}