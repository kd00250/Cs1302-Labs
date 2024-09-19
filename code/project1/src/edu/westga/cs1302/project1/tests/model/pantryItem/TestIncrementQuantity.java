package edu.westga.cs1302.project1.tests.model.pantryItem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.PantryItem;

class TestIncrementQuantity {

	@Test
	void testAddToDefaultQuantity() {
		PantryItem item = new PantryItem("Apple", "Fruit");
		item.incrementQuantity();

		assertEquals(1, item.getQuantity());
	}

	@Test
	void testAddToASetQuantity() {
		PantryItem item = new PantryItem("Apple", "Fruit");
		item.setQuantity(14);
		item.incrementQuantity();

		assertEquals(15, item.getQuantity());
	}

}
