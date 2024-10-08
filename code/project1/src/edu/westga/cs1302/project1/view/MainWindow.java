package edu.westga.cs1302.project1.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs1302.project1.model.PantryItem;
import edu.westga.cs1302.project1.model.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ListView<PantryItem> food;

	@FXML
	private TextField quantity;

	@FXML
	private TextField name;

	@FXML
	private ComboBox<String> type;

	@FXML
	void addFood(ActionEvent event) {
		String foodName = this.name.getText();
		String foodType = this.type.getSelectionModel().getSelectedItem();
		try {
			PantryItem item = new PantryItem(foodName, foodType);
			this.food.getItems().add(item);
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Unable to create food item. " + errorObject.getMessage()
					+ " Please reenter the information and try again.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void decrementQuantity(ActionEvent event) {
		PantryItem selectedFood = this.food.getSelectionModel().getSelectedItem();
		try {
			selectedFood.decrementQuantity();
			this.food.refresh();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Unable to subtract 1 from selected item quantity. " + errorObject.getMessage()
					+ " Please reenter the information and try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Cannot subtract from quantity. No food item selected. Select a food item and try again.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void incrementQuantity(ActionEvent event) {
		PantryItem selectedFood = this.food.getSelectionModel().getSelectedItem();
		try {
			selectedFood.incrementQuantity();
			this.food.refresh();
		} catch (NullPointerException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup
					.setContentText("Cannot add to quantity. No food item selected. Select a food item and try again.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void setQuantity(ActionEvent event) {
		PantryItem selectedFood = this.food.getSelectionModel().getSelectedItem();
		try {
			int newQuantity = Integer.parseInt(this.quantity.getText());
			selectedFood.setQuantity(newQuantity);
			this.food.refresh();
		} catch (NumberFormatException errorNum) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Cannot set quantity. Enter a quantity value and try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Cannot set quantity. No food item selected. Select a food item and try again.");
			errorPopup.showAndWait();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Unable to set item quantity. " + errorObject.getMessage()
					+ " Please reenter the information and try again.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void removeSelectedFood(ActionEvent event) {
		PantryItem selectedFood = this.food.getSelectionModel().getSelectedItem();
		if (selectedFood != null) {
			this.food.getItems().remove(selectedFood);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup
					.setContentText("Cannot remove food. There is no food selected. Select a food item and try again.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void countTotalItems(ActionEvent event) {
		try {
			Alert sumPopup = new Alert(Alert.AlertType.INFORMATION);
			sumPopup.setContentText("Total Quantity of items: " + Utility.getTotalQuantityOfItems(this.food));
			sumPopup.showAndWait();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Cannot count total quantity." + errorObject.getMessage() + " Add a food item and try again.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void initialize() {
		String[] types = { "Vegetable", "Meat", "Bread", "Fruit", "Dessert", "Ingredient" };
		this.type.getItems().addAll(types);
		assert this.food != null : "fx:id=\"food\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.type != null : "fx:id=\"type\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}

}