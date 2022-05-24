package at.ac.fhcampuswien.foodaddicts.controller;

import at.ac.fhcampuswien.foodaddicts.dto.RecipeDto;
import at.ac.fhcampuswien.foodaddicts.model.Recipe;
import at.ac.fhcampuswien.foodaddicts.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipe")
@AllArgsConstructor
public class RecipeController {
    private RecipeService recipeService;

    @PostMapping("/add")
    public RecipeDto add(@RequestBody RecipeDto recipeDto){
        return recipeService.addRecipe(recipeDto);
    }

    @GetMapping("/id/{id}")
    public Recipe get(@PathVariable long id){
        return recipeService.getRecipeById(id);
    }

    @GetMapping("/name/{name}")
    public Recipe getByName(@PathVariable String name){
        return recipeService.getRecipeByName(name);
    }

    @GetMapping("")
    public List<Recipe> getAll(){
        return recipeService.getRecipes();
    }
}

/*
* {
    "id": 3,
    "name": "Cake",
    "preparationTimeMinutes": 20,
    "workingTimeMinutes": 50,
    "calories": 500,
    "ingredients": [
        {
            "id": 3,
            "name": "Sugar",
            "amount": 2.0,
            "unit": "SPOON"
        },
        {
            "id": 4,
            "name": "Salt",
            "amount": 1.0,
            "unit": "SMALL_SPOON"
        }
    ],
    "preparation": [
        "Mix ingredients",
        "Add water",
        "Bake for 2 hours"
    ]
}
* */
