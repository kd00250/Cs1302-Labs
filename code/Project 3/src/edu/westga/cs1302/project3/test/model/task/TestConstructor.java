package edu.westga.cs1302.project3.test.model.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

public class TestConstructor {


	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Basketball");
		});
	}
	
	@Test
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Ball", null);
		});
	}
	
	@Test
	void testBlankTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("", "Basketball");
		});
	}
	
	@Test
	void testBlankDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Ball", " ");
		});
	}
	
	@Test
	void testValidConstructor() {
		Task task = new Task("Apple", "Tying shoe");
		
		assertEquals(task.getTitle(), "Apple");
		assertEquals(task.getDescription(), "Tying shoe");
	}
}
