package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.AddTaskWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {

	@FXML
	private Button addTask;

	@FXML
	private Button cancel;

	@FXML
	private TextArea descriptionTextArea;

	@FXML
	private TextField titleTextField;
	
	public void bindToVM(AddTaskWindowViewModel vm) {
	
	}

	@FXML
	void initialize() {
		assert addTask != null : "fx:id=\"addTask\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";
		assert cancel != null : "fx:id=\"cancle\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";
		assert descriptionTextArea != null
				: "fx:id=\"descriptionTextArea\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";
		assert titleTextField != null
				: "fx:id=\"titleTextField\" was not injected: check your FXML file 'AddTaskWindow.fxml'.";

	}
}
