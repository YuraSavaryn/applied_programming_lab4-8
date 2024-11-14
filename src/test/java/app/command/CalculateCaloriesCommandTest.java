package app.command;

import app.command.CalculateCaloriesCommand;
import app.saladservice.SaladService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class CalculateCaloriesCommandTest {
    @Mock
    private SaladService saladService;

    @InjectMocks
    private CalculateCaloriesCommand calculateCaloriesCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        calculateCaloriesCommand = new CalculateCaloriesCommand(saladService);
    }

    @Test
    void testExecute() {
        calculateCaloriesCommand.execute();

        verify(saladService).calculateCalories();
    }
}
