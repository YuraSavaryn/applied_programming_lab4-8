package app.command;

import app.command.SortIngredientsCommand;
import app.saladservice.SaladService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SortIngredientsCommandTest {
    @Mock
    private SaladService saladService;

    @Mock
    private Scanner scan;

    @InjectMocks
    private SortIngredientsCommand sortIngredientsCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sortIngredientsCommand = new SortIngredientsCommand(saladService, scan);
    }

    @Test
    void testExecute() {
        when(scan.nextInt()).thenReturn(1);

        sortIngredientsCommand.execute();

        verify(saladService).sortIngredients(1);
    }

    @Test
    void testExecute_InvalidChoice() {
        when(scan.nextInt()).thenReturn(3);

        sortIngredientsCommand.execute();

        verify(saladService, never()).sortIngredients(any(Integer.class));
    }
}
