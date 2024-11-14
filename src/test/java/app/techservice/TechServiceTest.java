package app.techservice;

import app.ingredient.Ingredient;
import app.saladservice.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TechServiceTest {
    private TechService techService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private Salad mockSalad;

    @Mock
    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        techService = new TechService();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testAddSalad() {
        techService.addSalad(mockSalad);
        assertEquals(1, techService.getSalads().size());
        assertEquals(mockSalad, techService.getSalads().get(0));
    }

    @Test
    void testOpenFridge_EmptyFridge() {
        techService.openFridge();
        assertEquals("Salad is empty.", outputStreamCaptor.toString().trim());
    }

    @Test
    void testOpenFridge_WithSalad() {
        when(mockSalad.getName()).thenReturn("Greek Salad");
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        when(mockSalad.getSalad()).thenReturn(ingredients);

        when(ingredient.getName()).thenReturn("Tomato");
        when(ingredient.getCalories()).thenReturn(20);
        when(ingredient.getWeight()).thenReturn(50);

        techService.addSalad(mockSalad);

        techService.openFridge();

        String expectedOutput = "Current salads in fridge:\n" +
                "1. Greek Salad\n" +
                "\t- Tomato (20 kcal, 50 grams)";
        String normalizedActualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n").replace("\r", "\n");
        assertEquals(expectedOutput, normalizedActualOutput);
    }
}