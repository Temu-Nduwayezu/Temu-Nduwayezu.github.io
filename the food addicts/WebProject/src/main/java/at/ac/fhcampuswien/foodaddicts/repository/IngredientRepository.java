package at.ac.fhcampuswien.foodaddicts.repository;

import at.ac.fhcampuswien.foodaddicts.model.Ingredient;
import at.ac.fhcampuswien.foodaddicts.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findIngredientByAmountAndNameAndUnit(double amount, String name, Unit unit);
    default boolean ingredientExists(Ingredient ingredient){
        return findIngredientByAmountAndNameAndUnit(ingredient.getAmount(), ingredient.getName(), ingredient.getUnit()).isPresent();
    }
}
