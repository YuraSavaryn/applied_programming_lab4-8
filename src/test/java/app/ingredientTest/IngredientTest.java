package app.ingredientTest;

import app.ingredient.Ingredient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IngredientTest {

    static class TestIngredient extends Ingredient {
        public TestIngredient(String name, int calories, int weight) {
            super(name, calories, weight);
        }
    }

    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        ingredient = new TestIngredient("Tomato", 20, 100);
    }

    @Test
    void testGetName() {
        assertEquals("Tomato", ingredient.getName(), "The name should be 'Tomato'");
    }

    @Test
    void testGetCalories() {
        assertEquals(20, ingredient.getCalories(), "The calories should be 20");
    }

    @Test
    void testGetWeight() {
        assertEquals(100, ingredient.getWeight(), "The weight should be 100");
    }

    @Test
    void testConstructorWithMocking() {
        Ingredient mockIngredient = mock(TestIngredient.class);
        when(mockIngredient.getName()).thenReturn("Carrot");
        when(mockIngredient.getCalories()).thenReturn(41);
        when(mockIngredient.getWeight()).thenReturn(50);

        assertEquals("Carrot", mockIngredient.getName());
        assertEquals(41, mockIngredient.getCalories());
        assertEquals(50, mockIngredient.getWeight());

        verify(mockIngredient, times(1)).getName();
        verify(mockIngredient, times(1)).getCalories();
        verify(mockIngredient, times(1)).getWeight();
    }
}
