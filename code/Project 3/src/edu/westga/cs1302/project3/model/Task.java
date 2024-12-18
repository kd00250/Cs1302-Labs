package edu.westga.cs1302.project3.model;

/**
 * The task class that store information for a single task
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Task {
	private String title;
	private String description;

	/**
	 * Creates a new instance of task
	 * 
	 * @precondition description != null && !description.isBlank() && title != null && !title.isBlank()
	 * @postcondition none
	 * 
	 * @param title       the title of the task
	 * @param description the description of the task
	 */
	public Task(String title, String description) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null");
		}
		if (title.isBlank()) {
			throw new IllegalArgumentException("Title cannot be blank");
		}
		if (description.isBlank()) {
			throw new IllegalArgumentException("Description cannot be blank");
		}

		this.title = title;
		this.description = description;
	}

	/**
	 * Gets title of the task
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the title of the task
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the description of the task
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the description of the title
	 */
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
