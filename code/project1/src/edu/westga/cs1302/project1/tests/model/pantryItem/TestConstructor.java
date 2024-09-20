package edu.westga.cs1302.project1.tests.model.pantryItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.PantryItem;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new PantryItem(null, "Fruit");
		});
	}

	@Test
	void testNotLongEnoughName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new PantryItem("ba", "Fruit");
		});
	}

	@Test
	void testNullType() {
		assertThrows(IllegalArgumentException.class, () -> {
			new PantryItem("Apple", null);
		});
	}

	@Test
	void testValidConstructo() {
		PantryItem item = new PantryItem("apple", "Fruit");

		assertEquals("apple", item.getName());
		assertEquals("Fruit", item.getType());

	}

}
