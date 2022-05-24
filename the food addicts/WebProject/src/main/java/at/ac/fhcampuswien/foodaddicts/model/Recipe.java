package at.ac.fhcampuswien.foodaddicts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    private Long recipe_id;
    private String name;
    private int preparationTimeMinutes;
    private int workingTimeMinutes;
    private int calories;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients = new HashSet<>();
    @ElementCollection
    private List<String> preparation;

    public Recipe(){
    }

    public Long getRecipeId() {
        return recipe_id;
    }

    public void setRecipeId(Long id) {
        this.recipe_id = id;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        ingredient.getRecipes().add(this);
    }
    public void removeIngredient(long ingredientId){
        Ingredient ingredient = this.ingredients.stream()
                .filter(element -> element.getId() == ingredientId)
                .findFirst()
                .orElse(null);
        if (ingredient != null){
            this.ingredients.remove(ingredient);
            ingredient.getRecipes().remove(this);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return preparationTimeMinutes == recipe.preparationTimeMinutes && workingTimeMinutes == recipe.workingTimeMinutes && calories == recipe.calories && Objects.equals(recipe_id, recipe.recipe_id) && Objects.equals(name, recipe.name) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(preparation, recipe.preparation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, name, preparationTimeMinutes, workingTimeMinutes, calories, ingredients, preparation);
    }
}
