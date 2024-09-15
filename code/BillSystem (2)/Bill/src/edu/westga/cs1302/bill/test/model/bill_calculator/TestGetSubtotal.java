package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetSubtotal {

	@Test
	void testOneItem() {
		BillItem item = new BillItem("Banana", 2.00);
		Bill bill = new Bill();
		bill.addItem(item);
		
		assertEquals(2.00, BillCalculator.getSubTotal(bill.getItems()));
	}
	
	@Test
	void testMultipleItems() {
		BillItem item1 = new BillItem("Banana", 2.00);
		BillItem item2 = new BillItem("Banana", 2.00);
		Bill bill = new Bill();
		bill.addItem(item1);
		bill.addItem(item2);
		
		assertEquals(4.00, BillCalculator.getSubTotal(bill.getItems()));
	}

}
