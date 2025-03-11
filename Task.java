/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.brooklyncollege.cisc3130.project.organizedtodolistapplication;

import java.time.LocalDate;
/*
 * this class task handles: accessors (gettets) and mutators (setters), constructor, toString methods, modifies timeSpent
*/

public class Task <T> {
 
    // Task fields
    private final T taskName;
    private final LocalDate dueDate;
    private final int priority;
    private final int estimatedTime;
    private int timeSpent;
    private boolean completed;

    // Constructor for ToDoItem
    public Task(T taskName, LocalDate dueDate, int priority, int estimatedTime, boolean completed, int timeSpent) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
        this.completed = completed;
        this.timeSpent = timeSpent;
    }

    // Getter for task name
    public T getTaskName() {
        return taskName;
    }

    // Getter for due date
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Getter for priority
    public int getPriority() {
        return priority;
    }

    // Getter for estimated time
    public int getEstimatedTime() {
        return estimatedTime;
    }

    // Getter for time spent
    public int getTimeSpent() {
        return timeSpent;
    }

    // Setter for time spent
    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    // Getter for completion status
    public boolean isCompleted() {
        return completed;
    }

    // Setter for completion status
    public void setCompletionStatus(boolean completed) {
        this.completed = completed;
    }

    // Mark as completed
    public void markAsCompleted() {
        completed = true;
    }

    // need a method addTimeSpent because it allows changes to time spent 
    public void addTimeSpent(int min) {
        timeSpent += min;
        if (timeSpent >= estimatedTime) {
            markAsCompleted();
        }
    }

    // need to override toString method 
    @Override
    public String toString() {
        return String.format("Task Name: %s, Due Date: %s, Priority: %d, Estimated Time: %d min, Time Spent: %d min, Completed Status: %s",
                taskName, dueDate, priority, estimatedTime, timeSpent, completed);
    }
}