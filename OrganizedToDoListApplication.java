/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.brooklyncollege.cisc3130.project.organizedtodolistapplication;

/* this main method class handles user input for OrganizedToDoListApplication 
 * I decided to use switch case rather than if else, since their would be multiple types of keywords, each key word would be based on a major method in the task class. 
 * Choosing to use a switch case is better for me because my code would look much more cleaner and easier for me to fix my code if needed. I also decided to add .trim() 
 * because of possible error to occur with white space the same thing .toLowerCase() with key word - as long as the user enters the correct order of the keyword it does not 
 * matter if it is Lowercase or uppercase - the code would still run. Also checks if there is duplicates name, and lets the user knows there is a duplicate taskName if want
 * to continue, or doesnt. And if they want to continue, the program continues asking questions. And the program store it properly.
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class OrganizedToDoListApplication {
    public static void main(String[] args) {
        TaskList<Task<String>> taskList = new TaskList<>();
        Scanner in = new Scanner(System.in);
        String keyWord;

        System.out.println("You have joined a text-based ToDoList application");

        while (true) {
            //this is something how it would look like 
            //System.out.println("\nEnter one of these key words: add, addSpecificIndex, remove, move, sort, display, exit");
            System.out.println("\nEnter add as a key word");
            System.out.print("Enter a key word: ");
            // .trim - prevents possible errors with whiteSpace
            // .toLowerCase - does not matter if user enters uppercase or lowercase would still run
            keyWord = in.nextLine().trim().toLowerCase();
            try {
                switch (keyWord) {
                    case "add":
                        String taskName;
                        while (true) {
                            System.out.print("\nEnter a task name: ");
                            taskName = in.nextLine();
                            // need to check if task name has a duplicate
                            // what if user entered it on purpose
                            if (taskList.containsTask(taskName)) {
                                System.out.print("You have entered a duplicate task name. Do you still want to add this task? (yes/no): ");
                                String response = in.nextLine().trim();
                                if (!response.equals("yes") && !response.equals("no")) {
                                    System.out.println("Invalid answer. Please respond with 'yes' or 'no'.");
                                    continue;
                                }
                                if (response.equals("no")) {
                                    continue; 
                                }
                                break; 
                            } else {
                                break; 
                            }
                        }

                        // Continuing with the other user inputs
                        System.out.print("Enter due date (YYYY-MM-DD): ");
                        // it is better to add .trim - prevent possible error 
                        LocalDate dueDate = LocalDate.parse(in.nextLine().trim());
                        LocalDate today = LocalDate.now();
                        // possible exception 
                        if (dueDate.isBefore(today)) throw new IllegalArgumentException("Due date cannot be in the past.");

                        System.out.print("Enter priority level from highest to lowest (1-5): ");
                        // add .trim  
                        int priority = Integer.parseInt(in.nextLine().trim());
                        // possible exception
                        if (priority < 1 || priority > 5) throw new IllegalArgumentException("Priority must be between 1 and 5.");

                        System.out.print("Enter an estimated time spent on this task (in minutes): ");
                        int estimatedTime = Integer.parseInt(in.nextLine());
                        System.out.print("Enter completion status (true/false): ");
                        boolean completionStatus = in.nextBoolean();
                        in.nextLine();

                        int timeSpent = 0;
                        if (completionStatus) {
                            System.out.print("Enter how long you have spent on this task (minutes): ");
                            // add .trim
                            timeSpent = Integer.parseInt(in.nextLine().trim());
                        }

                        // Add the task to the list
                        taskList.add(new Task<>(taskName, dueDate, priority, estimatedTime, completionStatus, timeSpent));
                        break;

                    case "exit":
                        System.out.println("You have decided to exit this text-based ToDoList application! ");
                        // need to close the scanner 
                        in.close(); 
                        // need to exit the program
                        return; 

                    default:
                        System.out.println("Try again. You have entered the wrong key word.");
                }
            // need to catch all possible exception
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format, please enter a number.");
            } catch (DateTimeParseException e) {
                System.out.println("You have entered an invalid date. You must enter the date in this format: YYYY-MM-DD ");
            } catch (IllegalArgumentException e) {
                System.out.println("You have entered a Illegal arguement: " + e.getMessage());
            // something else that I have not thought of 
            } catch (Exception e) {
                System.out.println("An error has an occured: " + e.getMessage());
            }
        }
    }

}
        
