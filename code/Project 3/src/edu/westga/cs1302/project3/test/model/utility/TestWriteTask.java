package edu.westga.cs1302.project3.test.model.utility;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.Utility;

class TestWriteTask {

	@Test
	void testSaveNullManager() {
		File file = new File("data.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.writeTask(null, file);
		});
	}
	
	@Test
	void testSaveNullFile() {
		TaskManager manager = new TaskManager();
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.writeTask(manager, null);
		});
	}

	@Test
	void testNoTasks() throws IOException {
		TaskManager manager = new TaskManager();
		File file = new File("data.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.writeTask(manager, file);
		});
	}

	@Test
	void testOneTask() throws IOException {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Cream", "Cheese Toast");
		File file = new File("data.txt");
		//file.wipeFile();
		manager.addTask(task1);
		Utility.writeTask(manager, file);

		try (Scanner reader = new Scanner(file)) {
			assertEquals("Cream", reader.nextLine());
			assertEquals("Cheese Toast", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}

	}

	@Test
	void testMultipleTasks() throws IOException {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Cream", "Cheese Toast");
		Task task2 = new Task("Cheat", "Cheese Toast");
		File file = new File("Test.txt");
		//file.wipeFile();
		manager.addTask(task1);
		manager.addTask(task2);
		Utility.writeTask(manager, file);
		
		try (Scanner reader = new Scanner(file)) {
			assertEquals("Cream", reader.nextLine());
			assertEquals("Cheese Toast", reader.nextLine());
			assertEquals("Cheat", reader.nextLine());
			assertEquals("Cheese Toast", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}
		

	}
	

//	@Test
//	void testMultipleManagers() throws IOException {
//		TaskManager manager = new TaskManager();
//		TaskManager manager2 = new TaskManager();
//		Task task1 = new Task("Cream", "Cheese Toast");
//		Task task2 = new Task("Cheat", "Cheese Toast");
//		File file = new File("Test2.txt");
//		//file.wipeFile();
//		manager.addTask(task1);
//		manager2.addTask(task2);
//		Utility.writeTask(manager, file);
//		Utility
//		
//		try (Scanner reader = new Scanner(file)) {
//			assertEquals("Cream", reader.nextLine());
//			assertEquals("Cheese Toast", reader.nextLine());
//			assertEquals("Cheat", reader.nextLine());
//			assertEquals("Cheese Toast", reader.nextLine());
//			assertFalse(reader.hasNextLine());
//		}
//
//	}

}
