package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.AddTaskWindowViewModel;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

	@FXML
	private AnchorPane pane;
	
	private AddTaskWindowViewModel addVM;

	private void closeWindow() {
		Stage stage = (Stage) (this.pane).getScene().getWindow();
		stage.close();
	}

	private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	/**
	 * Provides bindings for the functionality
	 * 
	 * @param vm the vm
	 */
	public void bindToVM(MainWindowViewModel vm) {
		this.addVM = new AddTaskWindowViewModel();
		this.addVM.titleProperty().bind(this.titleTextField.textProperty());
		this.addVM.descriptionProperty().bind(this.descriptionTextArea.textProperty());
		this.cancel.setOnAction((event) -> {
			this.closeWindow();
		});
		this.addTask.setOnAction((event) -> {
			try {
		vm.tasksProperty().add(this.addVM.getCreatedTask());
		this.closeWindow();
			} catch (IllegalArgumentException errorArg) {
				this.displayErrorPopup(errorArg.getMessage());
			}
		});
	}
}
