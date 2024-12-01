package edu.westga.cs1302.project3.viewmodel;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindowViewModel {

	private ListProperty<Task> tasksProperty;

	private TaskManager manager;

	/**
	 * Creates a new instance of MainWindowViewModel
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public MainWindowViewModel() {

		this.manager = new TaskManager();
		Task task = new Task("Throw", "I will throw the ball");
		Task task2 = new Task("Run", "I will run with the ball");
		this.manager.addTask(task);
		this.manager.addTask(task2);
		this.tasksProperty = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.manager.getTasks()));
	}

	/**
	 * Gets the tasks property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the task property list
	 */
	public ListProperty<Task> tasksProperty() {
		return this.tasksProperty;
	}

	/**
	 * Removes the specified task from the list
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param task the task to be removed
	 */
	public void removeTask(Task task) {
		this.tasksProperty.remove(task);
	}

}
