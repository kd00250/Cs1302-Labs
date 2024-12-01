package edu.westga.cs1302.project3.test.viewModel.MainWindow;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.Utility;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

class TestLoadTasks {

	@Test
	void testEmptyFile() throws IOException {
		MainWindowViewModel vm = new MainWindowViewModel();
		File file = new File("Tests.txt");
		vm.loadTasks(file);
		assertTrue(vm.tasksProperty().size() == 2);
	}

	@Test
	void testOneTaskFile() throws IOException {
		MainWindowViewModel vm = new MainWindowViewModel();
		TaskManager manager = new TaskManager();
		Task task = new Task("Cheese", "And Crackers");
		File file = new File("data.txt");
		manager.addTask(task);
		Utility.writeTask(manager, file);
		vm.loadTasks(file);

		assertEquals(1, Utility.loadTask(file).size());
		assertEquals(vm.tasksProperty().get(2).getTitle(), Utility.loadTask(file).get(0).getTitle());
		assertEquals(vm.tasksProperty().get(2).getDescription(), Utility.loadTask(file).get(0).getDescription());
	}

	@Test
	void testMultipleTasksInFile() throws IOException {
		MainWindowViewModel vm = new MainWindowViewModel();
		TaskManager manager = new TaskManager();
		Task task = new Task("Cheese", "And Crackers");
		Task task2 = new Task("Chess", "And Rook");
		File file = new File("Test.txt");
		manager.addTask(task);
		manager.addTask(task2);
		Utility.writeTask(manager, file);
		vm.loadTasks(file);

		assertEquals(2, Utility.loadTask(file).size());
		assertEquals(vm.tasksProperty().get(2).getTitle(), Utility.loadTask(file).get(0).getTitle());
		assertEquals(vm.tasksProperty().get(2).getDescription(), Utility.loadTask(file).get(0).getDescription());
		assertEquals(vm.tasksProperty().get(3).getTitle(), Utility.loadTask(file).get(1).getTitle());
		assertEquals(vm.tasksProperty().get(3).getDescription(), Utility.loadTask(file).get(1).getDescription());

	}

}
