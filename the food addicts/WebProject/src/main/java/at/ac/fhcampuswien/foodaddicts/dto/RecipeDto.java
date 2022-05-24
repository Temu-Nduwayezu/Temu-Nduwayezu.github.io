package at.ac.fhcampuswien.foodaddicts.dto;

import at.ac.fhcampuswien.foodaddicts.model.Ingredient;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeDto {
    private long recipeId;
    private String name;
    private int preparationTimeMinutes;
    private int workingTimeMinutes;
    private int calories;
    private Set<Ingredient> ingredients = new HashSet<>();
    private List<String> preparation;

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreparationTimeMinutes() {
        return preparationTimeMinutes;
    }

    public void setPreparationTimeMinutes(int preparationTimeMinutes) {
        this.preparationTimeMinutes = preparationTimeMinutes;
    }

    public int getWorkingTimeMinutes() {
        return workingTimeMinutes;
    }

    public void setWorkingTimeMinutes(int workingTimeMinutes) {
        this.workingTimeMinutes = workingTimeMinutes;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getPreparation() {
        return preparation;
    }

    public void setPreparation(List<String> preparation) {
        this.preparation = preparation;
    }
}
