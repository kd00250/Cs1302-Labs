package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private MenuItem addPeopleMenuItem;

	@FXML
	private Button addTask;

	@FXML
	private MenuItem addTaskMenuItem;

	@FXML
	private MenuItem closeMenuItem;

	@FXML
	private MenuItem loadTaskMenuItem;

	@FXML
	private AnchorPane pane;

	@FXML
	private Button removeTask;

	@FXML
	private MenuItem saveTasksMenuItem;

	@FXML
	private ListView<Task> tasks;

	private MainWindowViewModel vm;

	private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	void initialize() {
		this.vm = new MainWindowViewModel();
		this.tasks.setItems(this.vm.tasksProperty());
		this.removeTask.setOnAction((event) -> {
			Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
			if (selectedTask != null) {
				this.vm.removeTask(selectedTask);
			}

		});
		this.closeMenuItem.setOnAction((event) -> {
			Stage stage = (Stage) (this.pane).getScene().getWindow();
			stage.close();
		});
		this.loadTaskMenuItem.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Image File");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
					new ExtensionFilter("All Files", "*.*"));
			File selectedFile = fileChooser.showOpenDialog(new Stage());
			if (!selectedFile.getName().endsWith(".txt")) {
				this.displayErrorPopup(
						"The File selected is not in the proper format. Please select a text file and try again.");
			}
			if (selectedFile != null) {
				try {
					try {
						this.vm.loadTasks(selectedFile);
					} catch (Exception errorIO) {
						this.displayErrorPopup(errorIO.getMessage());
					}
				} catch (NoSuchElementException errorElement) {
					this.displayErrorPopup(
							"The File selected is missing a title and/or a description for the task. Please fix the file and try again.");
				} 
			}
		});
		this.saveTasksMenuItem.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Image File");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
					new ExtensionFilter("All Files", "*.*"));
			File selectedFile = fileChooser.showOpenDialog(new Stage());
			if (!selectedFile.getName().endsWith(".txt")) {
				this.displayErrorPopup(
						"The File selected cannot be written to. Please select a text file and try again.");
			} else {
				try {
					this.vm.saveTasks(this.vm.managerProperty(), selectedFile);
				} catch (IOException errorIO) {
					this.displayErrorPopup(errorIO.getMessage());
				}
			}

		});
	}
}
