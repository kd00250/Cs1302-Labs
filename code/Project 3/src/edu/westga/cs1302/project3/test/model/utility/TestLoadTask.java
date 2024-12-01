package edu.westga.cs1302.project3.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.Utility;

class TestLoadTask {

	@Test
	void testEmptyFile() throws IOException, NoSuchElementException {
		File file = new File("Tests.txt");
		Utility.loadTask(file);
		assertTrue(Utility.loadTask(file).size() == 0);
	}

	@Test
	void testOneTaskFile() throws IOException, NoSuchElementException {
		TaskManager manager = new TaskManager();
		Task task = new Task("Cheese", "And Crackers");
		File file = new File("data.txt");
		manager.addTask(task);
		Utility.writeTask(manager, file);
		Utility.loadTask(file);

		assertEquals(1, Utility.loadTask(file).size());
		assertEquals(task.getTitle(), Utility.loadTask(file).get(0).getTitle());
		assertEquals(task.getDescription(), Utility.loadTask(file).get(0).getDescription());
	}

	@Test
	void testMultipleTasksInFile() throws IOException, NoSuchElementException {
		TaskManager manager = new TaskManager();
		Task task = new Task("Cheese", "And Crackers");
		Task task2 = new Task("Chess", "And Rook");
		File file = new File("Test.txt");
		manager.addTask(task);
		manager.addTask(task2);
		Utility.writeTask(manager, file);
		Utility.loadTask(file);

		assertEquals(2, Utility.loadTask(file).size());
		assertEquals(task.getTitle(), Utility.loadTask(file).get(0).getTitle());
		assertEquals(task.getDescription(), Utility.loadTask(file).get(0).getDescription());
		assertEquals(task2.getTitle(), Utility.loadTask(file).get(1).getTitle());
		assertEquals(task2.getDescription(), Utility.loadTask(file).get(1).getDescription());

	}

}
