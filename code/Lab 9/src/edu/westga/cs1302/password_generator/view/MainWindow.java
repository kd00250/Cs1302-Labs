package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private MenuItem aboutMenuItem;
	@FXML
	private MenuItem closeMenuItem;
	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private TextArea output;
	@FXML
	private Label errorTextLabel;
	@FXML
	private Button generatePasswordButton;
	@FXML
	private AnchorPane pane;

	private ViewModel vm;

	@FXML
	void initialize() {
		this.vm = new ViewModel();
		this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
		this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
		this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
		this.minimumLength.setText(this.vm.getMinimumLength().getValue());
		this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
		this.setUpEnableControls();

		this.output.textProperty().bind(this.vm.getPassword());
		this.errorTextLabel.textProperty().bind(this.vm.getErrorText());

		this.generatePasswordButton.setOnAction((event) -> {
			this.vm.generatePassword();
		});

		this.closeMenuItem.setOnAction((event) -> {
			Stage stage = (Stage) (this.pane).getScene().getWindow();
			stage.close();
		});

		this.aboutMenuItem.setOnAction((event) -> {
			Alert popup = new Alert(Alert.AlertType.INFORMATION);
			popup.setContentText(
					"This Project generates a random password with the requirements based on the checkboxes selected and the minimum length entered.\n Author: Kenneth Dearman");
			popup.showAndWait();
		});
	}

	private void setUpEnableControls() {
		this.generatePasswordButton.disableProperty().bind(this.minimumLength.textProperty().isEmpty());
	}
}
