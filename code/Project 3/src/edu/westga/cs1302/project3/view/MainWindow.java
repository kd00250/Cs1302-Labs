package edu.westga.cs1302.project3.view;

import java.io.File;
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

/** Codebehind for the Main Window of the application.
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

    @FXML
    void initialize() {
    	this.vm = new MainWindowViewModel();
        this.tasks.setItems(this.vm.tasksProperty());
        
//        this.removeTask.setOnAction((event) -> {
//        	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
//        	if (selectedTask != null) {
//        	this.vm.removeTask(selectedTask);
//        	}
//        
//        });
        
        this.closeMenuItem.setOnAction((event) -> {
			Stage stage = (Stage) (this.pane).getScene().getWindow();
			stage.close(); 
		});
        
        this.loadTaskMenuItem.setOnAction((event) -> {
        	FileChooser fileChooser = new FileChooser();
        	fileChooser.setTitle("Open Image File");
        	fileChooser.getExtensionFilters().addAll(
        	new ExtensionFilter("Text Files", "*.txt"),
        	new ExtensionFilter("All Files", "*.*"));
        	File selectedFile = fileChooser.showOpenDialog(new Stage());
        	if (!selectedFile.getName().endsWith(".txt")) {
        		Alert popup = new Alert(Alert.AlertType.ERROR);
    			popup.setContentText(
    					"The File selected is not in the proper format. Please select a text file and try again.");
    			popup.showAndWait();
        	}
        	if (selectedFile != null) {
        		try {
        			this.vm.loadTasks(selectedFile);
        		} catch (IllegalArgumentException errorArg) {
        			Alert popup = new Alert(Alert.AlertType.ERROR);
        			popup.setContentText(
        					"The selected file is in improper format. Please selected a text file and try again." + errorArg.getMessage());
        			popup.showAndWait();
        		} catch (NoSuchElementException errorElement) {
        			Alert popup = new Alert(Alert.AlertType.ERROR);
        			popup.setContentText(
        					"The File selected is missing a title and/or a description for the task. Please fix the file and try again.");
        			popup.showAndWait();
        		}
        	} 
        });
    
        assert this.aboutMenuItem != null : "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.addPeopleMenuItem != null : "fx:id=\"addPeopleMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.addTask != null : "fx:id=\"addTask\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.addTaskMenuItem != null : "fx:id=\"addTaskMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.closeMenuItem != null : "fx:id=\"closeMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.loadTaskMenuItem != null : "fx:id=\"loadTaskMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.removeTask != null : "fx:id=\"removeTask\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.saveTasksMenuItem != null : "fx:id=\"saveTasksMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.tasks != null : "fx:id=\"tasks\" was not injected: check your FXML file 'MainWindow.fxml'.";  
    }
}
