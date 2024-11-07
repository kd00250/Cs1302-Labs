package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Class ViewModel.
 * 
 * @author CS1302
 * @version Fall 2024
 */
public class MainWindowViewModel {
	private PasswordGenerator generator;

	private StringProperty errorLabelProperty;
	private StringProperty minLengthProperty;
	private StringProperty outputProperty;
	private BooleanProperty mustIncludeDigitsProperty;
	private BooleanProperty mustIncludeLowerCaseLettersProperty;
	private BooleanProperty mustIncludeUpperCaseLettersProperty;

	/**
	 * Instantiates a new main window view model.
	 */
	public MainWindowViewModel() {

		this.generator = new PasswordGenerator(1);
		this.errorLabelProperty = new SimpleStringProperty("");
		this.minLengthProperty = new SimpleStringProperty("1");
		this.outputProperty = new SimpleStringProperty("");
		this.mustIncludeDigitsProperty = new SimpleBooleanProperty(false);
		this.mustIncludeLowerCaseLettersProperty = new SimpleBooleanProperty(false);
		this.mustIncludeUpperCaseLettersProperty = new SimpleBooleanProperty(false);

	}

	/**
	 * Gets the Error Label property.
	 *
	 * @return the errorLabel Property.
	 */
	public StringProperty errorLabelProperty() {
		return this.errorLabelProperty;
	}

	/**
	 * Gets the minLength property.
	 *
	 * @return the minLength Property.
	 */
	public StringProperty minLengthProperty() {
		return this.minLengthProperty;
	}

	/**
	 * Gets the output property.
	 *
	 * @return the output Property.
	 */
	public StringProperty outputProperty() {
		return this.outputProperty;
	}

	/**
	 * Gets the output property.
	 *
	 * @return the output Property.
	 */
	public BooleanProperty mustIncludeDigitsProperty() {
		return this.mustIncludeDigitsProperty;
	}

	/**
	 * Gets the output property.
	 *
	 * @return the output Property.
	 */
	public BooleanProperty mustIncludeLowerCaseLettersProperty() {
		return this.mustIncludeLowerCaseLettersProperty;
	}

	/**
	 * Gets the output property.
	 *
	 * @return the output Property.
	 */
	public BooleanProperty mustIncludeUpperCaseLettersProperty() {
		return this.mustIncludeUpperCaseLettersProperty;
	}

	/**
	 * Generates a password based on user input
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void generatePassword() {
		try {
			int minLength = Integer.parseInt(this.minLengthProperty.getValue());
			this.generator.setMinimumLength(minLength);
			this.generator.setMustHaveAtLeastOneDigit(this.mustIncludeDigitsProperty().get());
			this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.mustIncludeLowerCaseLettersProperty().get());
			this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.mustIncludeUpperCaseLettersProperty().get());

			this.outputProperty().set(this.generator.generatePassword());
			this.errorLabelProperty().set("");
		} catch (NumberFormatException numberError) {
			this.errorLabelProperty().set("Length must be a positive integer");
			return;
		} catch (IllegalArgumentException invalidLengthError) {
			this.errorLabelProperty().set("Minimum length must be at least 1");
			return;
		}

	}

}
