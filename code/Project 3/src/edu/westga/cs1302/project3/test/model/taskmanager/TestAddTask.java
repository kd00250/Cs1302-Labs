package edu.westga.cs1302.project3.test.model.taskmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestAddTask {

	@Test
	void testAddNullTask() {
		TaskManager taskManager = new TaskManager();

		assertThrows(IllegalArgumentException.class, () -> {
			taskManager.addTask(null);
		});
	}

	@Test
	void testAddDuplicateTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Apple", "Fruit");
		taskManager.addTask(task);

		assertThrows(IllegalArgumentException.class, () -> {
			taskManager.addTask(task);
		});
	}

	@Test
	void testAddOneTasks() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Apple", "Fruit");
		taskManager.addTask(task);

		assertTrue(taskManager.getTaskMap().containsKey(task.getTitle()));
		assertEquals(1, taskManager.getTasks().length);
		assertEquals(task, taskManager.getTasks()[0]);
	}

	@Test
	void testAddTwoTasks() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Apple", "Fruit");
		Task task2 = new Task("Mango", "Fruit");
		taskManager.addTask(task1);
		taskManager.addTask(task2);

		assertEquals(2, taskManager.getTasks().length);
		assertTrue(taskManager.getTaskMap().containsKey(task1.getTitle()));
		assertTrue(taskManager.getTaskMap().containsKey(task2.getTitle()));
		assertEquals(task1, taskManager.getTasks()[0]);
		assertEquals("Apple", taskManager.getTasks()[0].getTitle());
		assertEquals("Fruit", taskManager.getTasks()[0].getDescription());
		assertEquals(task2, taskManager.getTasks()[1]);
		assertEquals("Mango", taskManager.getTasks()[1].getTitle());
		assertEquals("Fruit", taskManager.getTasks()[1].getDescription());
	}

}
