package at.ac.fhcampuswien.foodaddicts.repository;

import at.ac.fhcampuswien.foodaddicts.model.Ingredient;
import at.ac.fhcampuswien.foodaddicts.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Repository
@Transactional(readOnly = true)
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);
}
