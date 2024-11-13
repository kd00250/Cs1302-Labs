package edu.westga.cs1302.password_generator.test.viewmodel.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestGeneratePassword {

	@Test
	void testMinimumLengthNotANumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("apple");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue());
		assertEquals("Invalid Minimum Length: must be a positive integer, but was apple", vm.getErrorText().getValue());
	}
	
	@Test
	void testMinimumLengthNotAValidNumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("-2");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue());
		assertEquals("Invalid Minimum Length: minimum length must be at least 1", vm.getErrorText().getValue());
	}
	
	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		vm.generatePassword();
		
		assertTrue(vm.getPassword().getValue().length() >= 2, "checking the password property has an appropriate number of characters");
		assertEquals("", vm.getErrorText().getValue());
	}
	
	@Test
	void testOnePasswordAddedToListView() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		vm.generatePassword();
		
		assertTrue(vm.getPassword().getValue().equals(vm.getPastPasswords().get(0)));
		assertEquals(vm.getPastPasswords().getSize(), 1, "checking the length of list");
	}
	
	@Test
	void testMultiplePasswordAddedToListView() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		vm.generatePassword();
		String password = vm.getPassword().getValue();
		vm.getMinimumLength().setValue("3");
		vm.generatePassword();
		String password2 = vm.getPassword().getValue();
		
		assertTrue(password.equals(vm.getPastPasswords().get(0)));
		assertTrue(password2.equals(vm.getPastPasswords().get(1)));
		assertEquals(vm.getPastPasswords().getSize(), 2, "checking the length of list");
	}
	
	@Test
	void testNoPasswordAddedToListView() {
		ViewModel vm = new ViewModel();
		
		assertEquals(vm.getPastPasswords().getSize(), 0, "checking the length of list");
	}

}
