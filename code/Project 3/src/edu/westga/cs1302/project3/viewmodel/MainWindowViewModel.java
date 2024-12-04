package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.Utility;
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
	 * Gets the manager property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the manager property
	 */
	public TaskManager managerProperty() {
		return this.manager;
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
	 * Loads the tasks in a file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param filePath the file path to load from
	 */
	public void loadTasks(File filePath) throws NoSuchElementException, IOException {
		ArrayList<Task> newTasks = Utility.loadTask(filePath);
		for (Task currentTask : newTasks) {
			this.tasksProperty.add(currentTask);
			this.manager.addTask(currentTask);
		}
	}

	/**
	 * Saves the task to the specified file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param manager  the manager that contains the tasks
	 * @param filePath the filePath that will be written to
	 * 
	 * @throws IOException           when missing task title/description
	 * @throws FileNotFoundException when the file does not exist
	 */
	public void saveTasks(TaskManager manager, File filePath) throws IOException {
		Utility.writeTask(manager, filePath);
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
		this.manager.removeTask(task);
		this.tasksProperty.remove(task);
	}
}
