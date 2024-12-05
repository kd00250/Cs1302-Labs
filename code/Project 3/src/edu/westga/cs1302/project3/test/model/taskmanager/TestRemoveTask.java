package edu.westga.cs1302.project3.test.model.taskmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestRemoveTask {

	@Test
	void testRemoveNullTask() {
		TaskManager taskManager = new TaskManager();

		assertThrows(IllegalArgumentException.class, () -> {
			taskManager.removeTask(null);
		});
	}

	@Test
	void testRemoveOneTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Apple", "Fruit");
		taskManager.addTask(task);
		taskManager.removeTask(task);

		assertEquals(0, taskManager.getTasks().length);
		assertFalse(taskManager.getTaskMap().containsKey(task.getTitle()));
	}

	@Test
	void testRemoveTwoTasks() {
		TaskManager taskManager = new TaskManager();
		Task task1 = new Task("Grapes", "Fruit");
		Task task2 = new Task("Mango", "Fruit");
		Task task3 = new Task("Apple", "Fruit");

		taskManager.addTask(task1);
		taskManager.addTask(task2);
		taskManager.addTask(task3);

		taskManager.removeTask(task1);
		taskManager.removeTask(task2);

		assertFalse(taskManager.getTaskMap().containsKey(task1.getTitle()));
		assertFalse(taskManager.getTaskMap().containsKey(task2.getTitle()));
		assertEquals(1, taskManager.getTasks().length);
		assertEquals(task3, taskManager.getTasks()[0]);
		assertEquals("Apple", taskManager.getTasks()[0].getTitle());
		assertEquals("Fruit", taskManager.getTasks()[0].getDescription());
	}

}
