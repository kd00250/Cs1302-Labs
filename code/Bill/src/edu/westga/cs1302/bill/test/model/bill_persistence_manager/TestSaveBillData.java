package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestSaveBillData {

	@Test
	void testSaveNullBill() {
		assertThrows(IllegalArgumentException.class, () -> {
			BillPersistenceManager.saveBillData(null);
		});
	}

	@Test
	void testNoBillItems() throws IOException {
		BillPersistenceManager.saveBillData(new Bill());

		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertFalse(reader.hasNextLine());
		}
	}

	@Test
	void testOneBillItem() throws IOException {
		Bill bill = new Bill();
		BillItem item = new BillItem("Apple", 2.00);
		bill.addItem(item);
		BillPersistenceManager.saveBillData(bill);

		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Apple,2.0", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}

	}

	@Test
	void testMultipleBillItems() throws IOException {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Apple", 1.50);
		BillItem item2 = new BillItem("Cheese", 2.00);
		bill.addItem(item1);
		bill.addItem(item2);
		BillPersistenceManager.saveBillData(bill);

		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Apple,1.5", reader.nextLine());
			assertEquals("Cheese,2.0", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}

	}

}
