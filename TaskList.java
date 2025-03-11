/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.brooklyncollege.cisc3130.project.organizedtodolistapplication;

/** I have decided to use Double Linked List mainly because in the future I will be implementing multiple methods that allows users to add and remove tasks at a certain index, 
 * since in a double linked list it takes constant time while an arrayList is linear. Although it may be easier to use use a single linked list, when dealing with edged cases. 
 * Since I will be importing LinkedList and extending it to my class, all I need to do is override methods that are already in the LinkedList class. Not just that it is
 * important to understand that in a single linked list is only allowed to move forward, not backwards compared to a double linked list which moves in both directions, making 
 * it more efficient. In the future I would will be adding a move method, that allows the user to move certain task to a different position, this allows the program to traverse 
 * more efficiently through the list. An arrayList is similar to a single link because it only moves forward. Another main issue with an arrayList is that it is considered to be 
 * a fixed size, and the programmer needs to create a grow method for the arrayList to grow method. Any methods that adds elements in a list, you would need to constantly 
 * call the grow method, to prevent the code from crashing. This makes the program more time consuming (Linear) for the run time. While in an Double Linked list you do not need
 * a grow method. I also imported Iterator class and implemented it to my class since I used an iterator for a specific method called containTask checking to see if the taskName
 * has any duplicates. In in my OrganizedToDoListApplication class checks if there is any duplicate name and ask the user if they knew about this and store it properly. 
 */

// need to import LinkedList and Iterator
import java.util.LinkedList;
import java.util.Iterator;
public class TaskList <T extends Task> extends LinkedList<T> implements Iterable<T> {

    // ADD methods
    
    // overriding add method - adds last elements to linked list
    // use super. since want it from super class
    @Override
    public boolean add(T elt) {
           return super.add(elt);
    }
    
    // need to override get method since already in Linked List class 
    // cal super. since want it from super class 
    // get(index) - calling the superclass methoda and enter the param 
    @Override
    public T get(int index) {
        return super.get(index);
    }

    // need to override the size method since from linked list class 
    // call super - since super class
    @Override
    public int size() {
        return super.size();
    }
    // deals with duplicates and Iterator 
    public boolean containsTask(String taskName) {
        Iterator<T> iterator = iterator();  
        // need loop if it iterators keeps going
        // constant time 
        while (iterator.hasNext()) {
            T task = iterator.next(); 
            // checking if duplicates if it does return true if not false
            if (task.getTaskName().equals(taskName)) {
                return true;  
            }
        }
        return false;
    }
}



    

