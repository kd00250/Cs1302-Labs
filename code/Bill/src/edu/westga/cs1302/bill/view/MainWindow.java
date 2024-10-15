package edu.westga.cs1302.bill.view;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The codebehind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	private Bill bill;

	@FXML
	private TextField name;
	@FXML
	private TextField amount;
	@FXML
	private TextArea receiptArea;
	@FXML
	private ComboBox<String> serverName;

	@FXML
	void addItem(ActionEvent event) {
		try {
			BillItem item = new BillItem(this.name.getText(), Double.parseDouble(this.amount.getText()));
			this.bill.addItem(item);
			this.name.clear();
			this.amount.clear();
			this.updateReceipt();
		} catch (NumberFormatException numError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add new bill item");
			alert.setContentText("Invalid amount provided, please correct and try again.");
			alert.showAndWait();
		} catch (IllegalArgumentException argError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add new bill item");
			alert.setContentText(argError.getMessage());
			alert.showAndWait();
		}
	}

	private void updateReceipt() {
		this.receiptArea.setText(BillTextifier.getText(this.bill));
	}

	@FXML
	void selectServer(ActionEvent event) {
		String name = this.serverName.getValue();
		if (name != null) {
			this.bill.setServerName(name);
			this.updateReceipt();
		}
	}

	@FXML
	void saveBillData(ActionEvent event) {
		try {
			BillPersistenceManager.saveBillData(this.bill);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Bill items saved successfully!");
			alert.showAndWait();
		} catch (IOException writeError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Could not write to file.");
			alert.showAndWait();
		} 
	}

	@FXML
	void initialize() {
		this.serverName.getItems().add("Bob");
		this.serverName.getItems().add("Alice");
		this.serverName.getItems().add("Trudy");
		this.bill = new Bill();
		this.updateReceipt();

		try {
			Bill loadBill = BillPersistenceManager.loadBillData();
			BillItem[] list = new BillItem[loadBill.getItems().length];
			list = loadBill.getItems();
			for (BillItem currentItem : list) {
				this.bill.addItem(currentItem);
			}
			this.updateReceipt();
		} catch (FileNotFoundException fileError) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("No save data file found, loading with no Bill data.");
			alert.showAndWait();
		} catch (IOException parseError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("File not in valid format.");
			alert.setContentText(parseError.getMessage());
			alert.showAndWait();
		}
	}
}
