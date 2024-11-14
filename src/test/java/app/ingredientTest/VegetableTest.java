package app.ingredientTest;

import app.ingredient.Vegetable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VegetableTest {

    static class TestVegetable extends Vegetable {
        public TestVegetable(String name, int calories, int weight) {
            super(name, calories, weight);
        }
    }

    private Vegetable vegetable;

    @BeforeEach
    void setUp() {
        vegetable = new VegetableTest.TestVegetable("Tomato", 20, 100);
    }

    @Test
    void testGetName() {
        assertEquals("Tomato", vegetable.getName(), "The name should be 'Tomato'");
    }

    @Test
    void testGetCalories() {
        assertEquals(20, vegetable.getCalories(), "The calories should be 20");
    }

    @Test
    void testGetWeight() {
        assertEquals(100, vegetable.getWeight(), "The weight should be 100");
    }
}
