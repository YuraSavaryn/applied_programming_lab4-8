package app.saladservice;

import app.ingredient.Ingredient;
import app.techservice.TechService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaladServiceTest {

    private SaladService saladService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @BeforeEach
    void setUp() {
        saladService = new SaladService();
        System.setOut(new PrintStream(outputStreamCaptor));

        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        when(ingredient1.getName()).thenReturn("Tomato");
        when(ingredient1.getCalories()).thenReturn(20);
        when(ingredient1.getWeight()).thenReturn(100);

        when(ingredient2.getName()).thenReturn("Cucumber");
        when(ingredient2.getCalories()).thenReturn(40);
        when(ingredient2.getWeight()).thenReturn(80);
    }

    @Test
    void testAddIngredient() {
        saladService.addIngredient(ingredient1);

        assertTrue(saladService.getSalad().contains(ingredient1), "Ingredient should be added to the salad");

        assertEquals("Tomato added to the salad.", outputStreamCaptor.toString().trim());
    }

    @Test
    void testRemoveIngredientExists() {
        saladService.addIngredient(ingredient1);

        outputStreamCaptor.reset();

        saladService.removeIngredient("Tomato");

        assertFalse(saladService.getSalad().contains(ingredient1), "Ingredient should be removed from the salad");

        assertEquals("Removing an ingredient: Tomato", outputStreamCaptor.toString().trim());
    }

    @Test
    void testRemoveIngredientNotExists() {
        outputStreamCaptor.reset();

        saladService.removeIngredient("Cucumber");

        assertEquals("Ingredient doesn't exists in salad!", outputStreamCaptor.toString().trim());
    }

    @Test
    void testCalculateCalories() {
        saladService.addIngredient(ingredient1);
        saladService.addIngredient(ingredient2);
        outputStreamCaptor.reset();

        saladService.calculateCalories();

        assertEquals("Total calories of the salad: " + 60 + " kcal", outputStreamCaptor.toString().trim());
    }

    @Test
    void testShowSaladWhenEmpty() {
        outputStreamCaptor.reset();

        saladService.showSalad();

        assertEquals("Salad is empty.", outputStreamCaptor.toString().trim());
    }

    @Test
    void testShowSaladWithIngredients() {
        saladService.addIngredient(ingredient1);

        outputStreamCaptor.reset();

        saladService.showSalad();

        String expectedOutput = "Current salad ingredients:\n- Tomato (20 kcal, 100 grams)";
        String normalizedActualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n").replace("\r", "\n");
        assertEquals(expectedOutput, normalizedActualOutput);
    }

    @Test
    void testSortIngredientsByCalories() {
        saladService.addIngredient(ingredient1);
        saladService.addIngredient(ingredient2);
        ArrayList<Ingredient> example = new ArrayList<>();
        example.add(ingredient1);
        example.add(ingredient2);

        outputStreamCaptor.reset();
        saladService.sortIngredients(1);

        ArrayList<Ingredient> salad = saladService.getSalad();

        assertTrue(example.equals(salad));
        assertEquals("Ingredients sorted by calories", outputStreamCaptor.toString().trim());
    }

    @Test
    void testSortIngredientsByWeight() {
        saladService.addIngredient(ingredient1);
        saladService.addIngredient(ingredient2);
        ArrayList<Ingredient> example = new ArrayList<>();
        example.add(ingredient2);
        example.add(ingredient1);

        outputStreamCaptor.reset();
        saladService.sortIngredients(2);

        ArrayList<Ingredient> salad = saladService.getSalad();

        assertTrue(example.equals(salad));
        assertEquals("Ingredients sorted by weight", outputStreamCaptor.toString().trim());
    }

    @Test
    void testMakeSaladWithIngredients() {
        TechService techService = mock(TechService.class);
        saladService.addIngredient(ingredient1);
        saladService.addIngredient(ingredient2);

        outputStreamCaptor.reset();

        saladService.makeSalad("Fresh Salad", techService);

        String expectedOutput = "A new salad has been created - Fresh Salad\n" +
                "Salad ingredients:\n" +
                "- Tomato (20 kcal, 100 grams)\n" +
                "- Cucumber (40 kcal, 80 grams)\n" +
                "Total weight of salad: 180 grams";
        String normalizedActualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n").replace("\r", "\n");
        assertEquals(expectedOutput, normalizedActualOutput);

        verify(techService).addSalad(any(Salad.class));
        assertEquals(0, saladService.getSalad().size());
    }

    @Test
    void testMakeEmptySalad() {
        TechService techService = mock(TechService.class);
        outputStreamCaptor.reset();

        saladService.makeSalad("Empty Salad", techService);

        String expectedOutput = "Salad is empty. You should add some ingredients";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());

        verify(techService, never()).addSalad(any(Salad.class));
    }
}