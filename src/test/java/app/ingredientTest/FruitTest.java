package app.ingredientTest;

import app.ingredient.Fruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FruitTest {

    static class TestFruit extends Fruit {
        public TestFruit(String name, int calories, int weight) {
            super(name, calories, weight);
        }
    }

    private Fruit fruit;

    @BeforeEach
    void setUp() {
        fruit = new FruitTest.TestFruit("Banana", 15, 100);
    }

    @Test
    void testGetName() {
        assertEquals("Banana", fruit.getName(), "The name should be 'Tomato'");
    }

    @Test
    void testGetCalories() {
        assertEquals(15, fruit.getCalories(), "The calories should be 20");
    }

    @Test
    void testGetWeight() {
        assertEquals(100, fruit.getWeight(), "The weight should be 100");
    }
}
