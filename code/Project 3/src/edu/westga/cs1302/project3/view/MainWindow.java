package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import edu.westga.cs1302.project3.Main;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.AddTaskWindowViewModel;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
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
	private AddTaskWindowViewModel addTaskVM;

	private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private File getFileChooserSelectedFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		return selectedFile;
	}
	
	private void getAddTaskWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.ADD_TASK_WINDOW));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setAddTaskStage = new Stage();
			setAddTaskStage.setTitle(Main.ADD_TASK_WINDOW_TITLE);
			setAddTaskStage.setScene(scene);
			setAddTaskStage.initModality(Modality.APPLICATION_MODAL);
			
			AddTaskWindow addTaskCodebehind = (AddTaskWindow) loader.getController();
			addTaskCodebehind.bindToVM(this.addTaskVM);
			
			setAddTaskStage.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
	}

	@FXML
	void initialize() {
		this.vm = new MainWindowViewModel();
		this.tasks.setItems(this.vm.tasksProperty());
//		this.removeTask.setOnAction((event) -> {
//			Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
//			if (selectedTask != null) {
//				this.vm.removeTask(selectedTask);
//			}
//		});
		this.closeMenuItem.setOnAction((event) -> {
			Stage stage = (Stage) (this.pane).getScene().getWindow();
			stage.close();
		});
		this.loadTaskMenuItem.setOnAction((event) -> {
			File selectedFile = this.getFileChooserSelectedFile();
			if (selectedFile != null) {
				if (!selectedFile.getName().endsWith(".txt")) {
					this.displayErrorPopup(
							"The File selected is not in the proper format. Please select a text file and try again.");
				}
				try {
					try {
						this.vm.loadTasks(selectedFile);
					} catch (IOException errorIO) {
						this.displayErrorPopup(errorIO.getMessage());
					}
				} catch (NoSuchElementException errorElement) {
					this.displayErrorPopup(
							"The File selected is missing a title and/or a description for the task. Please fix the file and try again.");
				}
			}
		});
		this.saveTasksMenuItem.setOnAction((event) -> {
			File selectedFile = this.getFileChooserSelectedFile();
			if (selectedFile != null) {
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
			}
		});
		this.addTask.setOnAction((event) -> {
			this.getAddTaskWindow();
		});
	}
}
