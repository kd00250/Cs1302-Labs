package edu.westga.cs1302.project2.view;

import java.io.IOException;
import java.util.Comparator;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.NameComparator;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeWriteToFile;
import edu.westga.cs1302.project2.model.TypeComparator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private ComboBox<String> ingredientType;
	@FXML
	private ListView<Ingredient> ingredientsList;
	@FXML
	private TextField ingredientName;
	@FXML
	private ComboBox<Comparator<Ingredient>> sortList;
	@FXML
	private ListView<Ingredient> recipeList;
	@FXML
	private TextField recipeName;
	@FXML
	private TextArea recipeDisplay;

	@FXML
	void addIngredient(ActionEvent event) {
		try {
			this.ingredientsList.getItems()
					.add(new Ingredient(this.ingredientName.getText(), this.ingredientType.getValue()));
			this.ingredientName.clear();
			this.ingredientType.getSelectionModel().clearSelection();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add ingredient");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
		this.sortBy(event);
		this.updateIngredientList();
	}

	@FXML
	void removeIngredient(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.ingredientsList.getItems().remove(selectedIngredient);
		}
		this.sortBy(event);
		this.updateIngredientList();
	}

	@FXML
	void sortBy(ActionEvent event) {
		this.ingredientsList.getItems().sort(this.sortList.getValue());
		this.updateIngredientList();
	}

	private void updateIngredientList() {
		this.ingredientsList.refresh();
	}

	private void updateRecipeList() {
		this.recipeList.refresh();
	}

	private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	void addRecipeToBook(ActionEvent event) {
		try {
			Recipe recipe = new Recipe(this.recipeName.getText());
			for (Ingredient currentIngredient : this.recipeList.getItems()) {
				recipe.addIngredient(currentIngredient);
			}
			RecipeWriteToFile file = new RecipeWriteToFile();
			file.appendFile(recipe);
			this.recipeList.getItems().clear();
			this.recipeName.setText("");
			this.updateRecipeList();
		} catch (IOException ioError) {
			this.displayErrorPopup(ioError.getMessage());
		} catch (IllegalArgumentException argError) {
			this.displayErrorPopup(argError.getMessage());
		}
	}

	@FXML
	void addToRecipe(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		this.recipeList.getItems().add(selectedIngredient);
		this.updateIngredientList();

	}

	@FXML
	void displayRecipes(ActionEvent event) {

	}

	@FXML
	void initialize() {
		this.ingredientType.getItems().add("Vegetable");
		this.ingredientType.getItems().add("Meat");
		this.ingredientType.getItems().add("Bread");
		this.ingredientType.getItems().add("Fruit");
		this.ingredientType.getItems().add("Spice");

		this.sortList.getItems().add(new NameComparator());
		this.sortList.getItems().add(new TypeComparator());
		this.sortList.setValue(this.sortList.getItems().get(0));
	}
}
