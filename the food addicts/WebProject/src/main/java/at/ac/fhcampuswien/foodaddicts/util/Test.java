package at.ac.fhcampuswien.foodaddicts.util;

import at.ac.fhcampuswien.foodaddicts.model.Ingredient;
import at.ac.fhcampuswien.foodaddicts.model.Recipe;
import at.ac.fhcampuswien.foodaddicts.model.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Ingredient ingredient = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        Set<Ingredient> ingredients = new HashSet<>();
        List<String> preparation = new ArrayList<>();
        ingredient.setId(443L);
        ingredient.setName("Sugar");
        ingredient.setAmount(2);
        ingredient.setUnit(Unit.SPOON);

        ingredient2.setId(444L);
        ingredient2.setName("Salt");
        ingredient2.setAmount(1);
        ingredient2.setUnit(Unit.SMALL_SPOON);

        ingredients.add(ingredient);
        ingredients.add(ingredient2);

        preparation.add("Mix ingredients");
        preparation.add("Add water");
        preparation.add("Bake for 2 hours");

        Recipe recipe = new Recipe();
        recipe.setRecipeId(223L);
        recipe.setName("Cake");
        recipe.setCalories(500);
        recipe.setIngredients(ingredients);
        recipe.setPreparation(preparation);
        recipe.setPreparationTimeMinutes(20);
        recipe.setWorkingTimeMinutes(50);

        // gson oder jackson


    }
}
