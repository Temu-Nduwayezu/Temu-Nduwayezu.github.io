package at.ac.fhcampuswien.foodaddicts.util;

import at.ac.fhcampuswien.foodaddicts.dto.RecipeDto;
import at.ac.fhcampuswien.foodaddicts.model.Recipe;

public class Converter {
    public static Recipe toRecipe(RecipeDto recipeDto){
        Recipe recipe = new Recipe();
        recipe.setRecipeId(recipeDto.getRecipeId());
        recipe.setName(recipeDto.getName());
        recipe.setWorkingTimeMinutes(recipeDto.getWorkingTimeMinutes());
        recipe.setCalories(recipeDto.getCalories());
        recipe.setPreparation(recipeDto.getPreparation());
        recipe.setPreparationTimeMinutes(recipeDto.getPreparationTimeMinutes());
        recipe.setIngredients(recipeDto.getIngredients());
        return recipe;
    }
    public static RecipeDto toRecipeDto(Recipe recipe){
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setRecipeId(recipe.getRecipeId());
        recipeDto.setName(recipe.getName());
        recipeDto.setWorkingTimeMinutes(recipe.getWorkingTimeMinutes());
        recipeDto.setCalories(recipe.getCalories());
        recipeDto.setPreparation(recipe.getPreparation());
        recipeDto.setPreparationTimeMinutes(recipe.getPreparationTimeMinutes());
        recipeDto.setIngredients(recipe.getIngredients());
        return recipeDto;
    }
}
