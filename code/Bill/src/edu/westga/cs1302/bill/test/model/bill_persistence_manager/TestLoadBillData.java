package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestLoadBillData {

	@Test
	void testEmptyFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("");
		}
		Bill bill = BillPersistenceManager.loadBillData();
		assertEquals(0, bill.getItems().length);
	}
	
	@Test
	void testOneBillItemInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("aaa,12.50"+ System.lineSeparator());
		}
		Bill bill = BillPersistenceManager.loadBillData();
		BillItem[] list = new BillItem[bill.getItems().length];
		list = bill.getItems();
		
		assertEquals(1, list.length);
		assertEquals("aaa", list[0].getName());
		assertEquals(12.5, list[0].getAmount());
	}
	
	@Test
	void testMultipleBillItemsInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("aaa,12.50" + System.lineSeparator());
			writer.write("bbb,22.61" + System.lineSeparator());
		}
		Bill bill = BillPersistenceManager.loadBillData();
		BillItem[] list = new BillItem[bill.getItems().length];
		list = bill.getItems();
		
		assertEquals(2, list.length);
		assertEquals("aaa", list[0].getName());
		assertEquals(12.5, list[0].getAmount());
		assertEquals("bbb", list[1].getName());
		assertEquals(22.61, list[1].getAmount());	
	}
	
	@Test
	void testOneBillItemInFileWithInvalidName() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write(",12.42" + System.lineSeparator());
		}
		assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
	}
	
	@Test
	void testOneBillItemInFileWithInvalidAmount() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("aac,one" + System.lineSeparator());
		}
		assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
	}
	
	@Test
	void testIncompleteBillItemInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("qqq" + System.lineSeparator());
		}
		assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
		
	}

}
