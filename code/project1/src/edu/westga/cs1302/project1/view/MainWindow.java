package edu.westga.cs1302.project1.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	private ListView<?> food;

	@FXML
	private TextField name;

	@FXML
	private ComboBox<?> type;

	@FXML
	void addFood(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert this.food != null : "fx:id=\"food\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.type != null : "fx:id=\"type\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}

}