package edu.westga.cs1302.project3.viewmodel;

import edu.westga.cs1302.project3.model.Task;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Codebehind for the AddTaskWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindowViewModel {

	private StringProperty title;
	private StringProperty description;

	/**
	 * Creates a new instance of AddTaskWindowViewModel
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public AddTaskWindowViewModel() {
		this.title = new SimpleStringProperty("");
		this.description = new SimpleStringProperty("");
	}

	/**
	 * Gets the title property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the title property
	 */
	public StringProperty titleProperty() {
		return this.title;
	}

	/**
	 * Gets the description property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the description property
	 */
	public StringProperty descriptionProperty() {
		return this.description;
	}

	/**
	 * Gets the task from the title and description given by the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the task created by the user input
	 */
	public Task getCreatedTask() {
		String title = this.title.get();
		String description = this.description.get();
		Task task = new Task(title, description);

		return task;
	}

}
