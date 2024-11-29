package edu.westga.cs1302.project3.test.model.taskmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestGetTasks {

	@Test
	void testNoTask() {
		TaskManager taskManager = new TaskManager();

		assertEquals(0, taskManager.getTasks().length);
	}
	
	@Test
	void testOneTasks() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Apple", "Fruit");
		taskManager.addTask(task);

		assertEquals(1, taskManager.getTasks().length);
		assertEquals(task, taskManager.getTasks()[0]);
	}

	@Test
	void testTwoTasks() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Apple", "Fruit");
		Task task2 = new Task("Mango", "Fruit");
		taskManager.addTask(task1);
		taskManager.addTask(task2);

		assertEquals(2, taskManager.getTasks().length);
		assertEquals(task1, taskManager.getTasks()[0]);
		assertEquals("Apple", taskManager.getTasks()[0].getTitle());
		assertEquals("Fruit", taskManager.getTasks()[0].getDescription());
		assertEquals(task2, taskManager.getTasks()[1]);
		assertEquals("Mango", taskManager.getTasks()[1].getTitle());
		assertEquals("Fruit", taskManager.getTasks()[1].getDescription());
	}

}
