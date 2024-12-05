package edu.westga.cs1302.project3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The Utility Class
 * 
 * @author CS 1302
 * @version fall 2024
 */
public class Utility {

	/**
	 * Loads the tasks from a file
	 * 
	 * @precondition filePath == null
	 * @postcondition none
	 * 
	 * @param filePath the filePath to load the tasks from
	 * @return arrayList of tasks
	 */
	public static ArrayList<Task> loadTask(File filePath) throws NoSuchElementException, IOException {
		if (filePath == null) {
			throw new IllegalArgumentException("FilePath cannot be null.");
		}
		ArrayList<Task> tasks = new ArrayList<Task>();
		try (Scanner reader = new Scanner(filePath)) {
			while (reader.hasNextLine()) {
				String title = reader.nextLine().strip();
				String description = reader.nextLine().strip();
				Task task = new Task(title, description);
				tasks.add(task);
			}
		} catch (FileNotFoundException fileError) {
			return tasks;
		}
		return tasks;
	}

	/**
	 * Writes the tasks to a file
	 * 
	 * @precondition filePath == null && manager == null && manager.getTasks().length != 0
	 * @postcondition none
	 * 
	 * @param manager  the manager that contains the tasks
	 * @param filePath the filePath to write the tasks
	 * @throws IOException           when missing task title/description
	 * @throws FileNotFoundException when file does not exsist
	 */
	public static void writeTask(TaskManager manager, File filePath) throws IOException {
		if (filePath == null) {
			throw new IllegalArgumentException("FilePath cannot be null.");
		}
		if (manager == null) {
			throw new IllegalArgumentException("TaskManager cannot be null.");
		}
		if (manager.getTasks().length == 0) {
			throw new IllegalArgumentException("No tasks added. Please add tasks and try again.");
		}
		try (FileWriter writer = new FileWriter(filePath)) {
			for (Task currentTask : manager.getTasks()) {
				writer.write(currentTask.getTitle() + System.lineSeparator() + currentTask.getDescription()
						+ System.lineSeparator());
			}
		}
	}

}
