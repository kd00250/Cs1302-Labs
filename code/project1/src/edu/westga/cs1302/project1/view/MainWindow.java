package edu.westga.cs1302.project1.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs1302.project1.model.PantryItem;
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
			errorPopup.setContentText("Unable to create food item " + errorObject.getMessage()
					+ " Please reenter the information and try again");
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