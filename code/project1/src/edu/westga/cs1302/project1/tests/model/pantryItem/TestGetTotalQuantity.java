package edu.westga.cs1302.project1.tests.model.pantryItem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.PantryItem;
import edu.westga.cs1302.project1.model.Utility;

class TestGetTotalQuantity {

	@Test
	void testSingleItemQuantity() {
		PantryItem item = new PantryItem("Apple", "Fruit");
		ArrayList<PantryItem> foodItems = new ArrayList<PantryItem>();
		item.incrementQuantity();
		foodItems.add(item);
		
		assertEquals(1, Utility.getTotalQuantity(foodItems));
	}
	
	@Test
	void testMultipleItemQuantity() {
		PantryItem item1 = new PantryItem("Apple", "Fruit");
		PantryItem item2 = new PantryItem("Grapes", "Fruit");
		ArrayList<PantryItem> foodItems = new ArrayList<PantryItem>();
		item1.incrementQuantity();
		item2.setQuantity(14);
		foodItems.add(item1);
		foodItems.add(item2);
		
		assertEquals(15, Utility.getTotalQuantity(foodItems));
	}

}
