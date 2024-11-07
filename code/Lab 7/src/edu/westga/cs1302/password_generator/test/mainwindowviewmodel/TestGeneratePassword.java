package edu.westga.cs1302.password_generator.test.mainwindowviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.MainWindowViewModel;

class TestGeneratePassword {

	@Test
	void testMinimumLength1NoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("1");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		assertTrue(1 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3NoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterNoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(true);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneDigitNoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(true);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterNoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(true);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterAtLeastOneUpperCaseLetterNoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(true);
		main.mustIncludeUpperCaseLettersProperty().set(true);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterAtLeastOneDigitNoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(true);
		main.mustIncludeLowerCaseLettersProperty().set(true);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterAtLeastOneDigitNoOtherRestriction() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(true);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(true);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterAtLeastOneLowerCaseLetterAtLeastOneDigit() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("3");
		main.mustIncludeDigitsProperty().set(true);
		main.mustIncludeLowerCaseLettersProperty().set(true);
		main.mustIncludeUpperCaseLettersProperty().set(true);
		
		main.generatePassword();
		
		String result = main.outputProperty().getValue();
		
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testMinimumLengthNegative1Error() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("-1");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		
		main.generatePassword();
		
		String errorMessage = main.errorLabelProperty().getValue();
		
		assertEquals(errorMessage, "Minimum length must be at least 1", "checking generated contents of error label");
	}
	
	@Test
	void testMinimumLengthNumberFormatError() {
		MainWindowViewModel main = new MainWindowViewModel();
		main.minLengthProperty().set("a");
		main.mustIncludeDigitsProperty().set(false);
		main.mustIncludeLowerCaseLettersProperty().set(false);
		main.mustIncludeUpperCaseLettersProperty().set(false);
		
		main.generatePassword();
		
		String errorMessage = main.errorLabelProperty().getValue();
		
		assertEquals(errorMessage, "Length must be a positive integer", "checking generated contents of error label");
	}

}
