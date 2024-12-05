package edu.westga.cs1302.project3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The system class that stores a set of tasks
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class TaskManager {
	private ArrayList<Task> tasks;
	private final Map<String, Task> taskMap;

	/**
	 * Creates a new Instance of TaskManager
	 */
	public TaskManager() {

		this.tasks = new ArrayList<Task>();
		this.taskMap = new HashMap<String, Task>();
	}

	/**
	 * Gets the hash map of students
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the hash map of students
	 */
	public Map<String, Task> getTaskMap() {
		return this.taskMap;
	}

	/**
	 * Adds task to the tasks list
	 * 
	 * @precondition task == null and !this.taskMap.containsKey(task.getTitle()
	 * @postcondition none
	 * 
	 * @param task the task to add
	 */
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Cannot add null task.");
		}
		if (this.taskMap.containsKey(task.getTitle())) {
			throw new IllegalArgumentException("Cannot add duplicate tasks. Task Already exists.");
		} else {
			this.taskMap.put(task.getTitle(), task);
			this.tasks.add(task);
		}
	}

	/**
	 * Removes task from the list
	 * 
	 * @precondition task == null
	 * @postcondition none
	 * @param task the task to remove
	 */
	public void removeTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Cannot remove null task.");
		}
		this.taskMap.remove(task.getTitle());
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
