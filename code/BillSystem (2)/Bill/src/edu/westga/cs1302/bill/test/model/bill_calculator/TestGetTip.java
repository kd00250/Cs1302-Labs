package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTip {

	@Test
	void testOneItem() {
		BillItem item = new BillItem("Banana", 2.00);
		Bill bill = new Bill();
		bill.addItem(item);
		
		assertEquals(.4, BillCalculator.getTip(bill.getItems()));
	}
	
	@Test
	void testMultipleItems() {
		BillItem item1 = new BillItem("Banana", 2.00);
		BillItem item2 = new BillItem("Banana", 2.00);
		Bill bill = new Bill();
		bill.addItem(item1);
		bill.addItem(item2);
		
		assertEquals(.8, BillCalculator.getTip(bill.getItems()));
	}

}
