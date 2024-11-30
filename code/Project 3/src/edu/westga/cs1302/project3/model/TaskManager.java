package edu.westga.cs1302.project3.model;

import java.util.ArrayList;

/**
 * The system class that stores a set of tasks
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class TaskManager {
	private ArrayList<Task> tasks;

	/**
	 * Creates a new Instance of TaskManager
	 */
	public TaskManager() {

		this.tasks = new ArrayList<Task>();
	}

	/**
	 * Adds task to the tasks list
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param task the task to add
	 */
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Cannot add null task.");
		}
		this.tasks.add(task);
	}

	/**
	 * Removes task from the list
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param task the task to remove
	 */
	public void removeTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Cannot remove null task.");
		}
		this.tasks.remove(task);
	}

	/**
	 * Gets the tasks and stores them in a array
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return array of tasks
	 */
	public Task[] getTasks() {
		return this.tasks.toArray(new Task[this.tasks.size()]);
	}
}
