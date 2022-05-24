package at.ac.fhcampuswien.foodaddicts.service;

import at.ac.fhcampuswien.foodaddicts.dto.RecipeDto;
import at.ac.fhcampuswien.foodaddicts.model.Ingredient;
import at.ac.fhcampuswien.foodaddicts.model.Recipe;
import at.ac.fhcampuswien.foodaddicts.repository.IngredientRepository;
import at.ac.fhcampuswien.foodaddicts.repository.RecipeRepository;
import at.ac.fhcampuswien.foodaddicts.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeDto addRecipe(RecipeDto recipeDto){
        boolean recipeExists = recipeRepository.findByName(recipeDto.getName()).isPresent();
        if (recipeExists){
            throw new IllegalStateException("Recipe " + recipeDto.getName() + " already exists!");
        }
        for(Ingredient ingredient : recipeDto.getIngredients()){
            if (!ingredientRepository.ingredientExists(ingredient)){
                ingredientRepository.save(ingredient);
            }
        }
        Recipe recipe = recipeRepository.save(Converter.toRecipe(recipeDto));
        return Converter.toRecipeDto(recipe);
    }

    public Recipe getRecipeById(long recipeId){
        return recipeRepository.findById(recipeId).orElseThrow();
    }

    public Recipe getRecipeByName(String name){
        return recipeRepository.findByName(name).orElseThrow();
    }

    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

}
