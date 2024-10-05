package edu.westga.cs1302.bill.model;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillPersistenceManager {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @throws IllegalArgumentException when precondition is violated
	 * @throws IOException when the file writer can not write to the file
	 * @param bill the bill to save
	 */
	public static void saveBillData(Bill bill) throws IllegalArgumentException, IOException {
		if (bill == null) {
			throw new IllegalArgumentException("Bill cannot be null");
		}
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			for (BillItem currentItem : bill.getItems()) {
				writer.write(currentItem.getName() + "," + currentItem.getAmount() + System.lineSeparator());
			}
		}
	}

	/**
	 * Load the bill!
	 * 
	 * Reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 */
	public static Bill loadBillData() {
		return null;
	}

}
