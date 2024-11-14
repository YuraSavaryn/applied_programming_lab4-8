package app.command;

import app.command.RemoveIngredientCommand;
import app.saladservice.SaladService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RemoveIngredientCommandTest {

    @Mock
    private SaladService saladService;

    @Mock
    private Scanner scan;

    @InjectMocks
    private RemoveIngredientCommand removeIngredientCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        removeIngredientCommand = new RemoveIngredientCommand(saladService, scan);
    }

    @Test
    void testExecute() {
        when(scan.nextLine()).thenReturn("Tomato");

        removeIngredientCommand.execute();

        verify(saladService).removeIngredient("Tomato");
    }
}
