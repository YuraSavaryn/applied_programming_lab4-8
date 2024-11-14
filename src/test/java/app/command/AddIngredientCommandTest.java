package app.command;

import app.ingredient.Fruit;
import app.ingredient.Meat;
import app.ingredient.Vegetable;
import app.saladservice.SaladService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddIngredientCommandTest {

    @Mock
    private SaladService saladService;

    @Mock
    private Scanner scan;

    @InjectMocks
    private AddIngredientCommand addIngredientCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addIngredientCommand = new AddIngredientCommand(saladService, scan);
    }

    @Test
    void testExecute_Vegetable() {
        when(scan.nextInt()).thenReturn(1).thenReturn(20).thenReturn(100);
        when(scan.nextLine()).thenReturn("Tomato");

        addIngredientCommand.execute();

        ArgumentCaptor<Vegetable> captor = ArgumentCaptor.forClass(Vegetable.class);
        verify(saladService).addIngredient(captor.capture());
        Vegetable capturedVegetable = captor.getValue();

        assertEquals("Tomato", capturedVegetable.getName());
        assertEquals(20, capturedVegetable.getCalories());
        assertEquals(100, capturedVegetable.getWeight());
    }

    @Test
    void testExecute_Fruit() {
        when(scan.nextInt()).thenReturn(2).thenReturn(50).thenReturn(100);
        when(scan.nextLine()).thenReturn("Banana");

        addIngredientCommand.execute();

        ArgumentCaptor<Fruit> captor = ArgumentCaptor.forClass(Fruit.class);
        verify(saladService).addIngredient(captor.capture());
        Fruit capturedFruit = captor.getValue();

        assertEquals("Banana", capturedFruit.getName());
        assertEquals(50, capturedFruit.getCalories());
        assertEquals(100, capturedFruit.getWeight());
    }

    @Test
    void testExecute_Meat() {
        when(scan.nextInt()).thenReturn(3).thenReturn(200).thenReturn(150);
        when(scan.nextLine()).thenReturn("Chicken");

        addIngredientCommand.execute();

        ArgumentCaptor<Meat> captor = ArgumentCaptor.forClass(Meat.class);
        verify(saladService).addIngredient(captor.capture());
        Meat capturedMeat = captor.getValue();

        assertEquals("Chicken", capturedMeat.getName());
        assertEquals(200, capturedMeat.getCalories());
        assertEquals(150, capturedMeat.getWeight());
    }

    @Test
    void testExecute_InvalidChoice() {
        when(scan.nextInt()).thenReturn(4);

        addIngredientCommand.execute();

        verify(saladService, never()).addIngredient(any());
    }
}
