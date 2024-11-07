package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private Label errorLabel;
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
	private MainWindowViewModel viewModel;

	// private PasswordGenerator generator;

	/**
	 * Instantiates a new main window view model code behind.
	 * 
	 * @precondition none
	 * @precondition none
	 */
	public MainWindow() {
		this.viewModel = new MainWindowViewModel();
	}

	@FXML
	void initialize() {
		this.minimumLength.setText("1");
		this.bindComponentsToViewModel();
		this.output.setEditable(false);
	}

	private void bindComponentsToViewModel() {
		this.errorLabel.textProperty().bind(this.viewModel.errorLabelProperty());
		this.minimumLength.textProperty().bindBidirectional(this.viewModel.minLengthProperty());
		this.output.textProperty().bind(this.viewModel.outputProperty());
		this.mustIncludeDigits.selectedProperty().bindBidirectional(this.viewModel.mustIncludeDigitsProperty());
		this.mustIncludeLowerCaseLetters.selectedProperty()
				.bindBidirectional(this.viewModel.mustIncludeLowerCaseLettersProperty());
		this.mustIncludeUpperCaseLetters.selectedProperty()
				.bindBidirectional(this.viewModel.mustIncludeUpperCaseLettersProperty());
	}

	@FXML
	void handleGeneratePassword(ActionEvent event) {
		this.viewModel.generatePassword();
	}
}
