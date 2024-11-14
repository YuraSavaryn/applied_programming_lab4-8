package app.ingredientTest;

import app.ingredient.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeatTest {

    static class TestMeat extends Meat {
        public TestMeat(String name, int calories, int weight) {
            super(name, calories, weight);
        }
    }

    private Meat meat;

    @BeforeEach
    void setUp() {
        meat = new MeatTest.TestMeat("Beef", 80, 100);
    }

    @Test
    void testGetName() {
        assertEquals("Beef", meat.getName(), "The name should be 'Beef'");
    }

    @Test
    void testGetCalories() {
        assertEquals(80, meat.getCalories(), "The calories should be 20");
    }

    @Test
    void testGetWeight() {
        assertEquals(100, meat.getWeight(), "The weight should be 100");
    }
}
