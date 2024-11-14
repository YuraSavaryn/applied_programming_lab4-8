package app.command;

import app.command.ShowSaladCommand;
import app.saladservice.SaladService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ShowSaladCommandTest {
    @Mock
    private SaladService saladService;

    @InjectMocks
    private ShowSaladCommand showSaladCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        showSaladCommand = new ShowSaladCommand(saladService);
    }

    @Test
    void testExecute() {
        showSaladCommand.execute();

        verify(saladService).showSalad();
    }
}
