package app.command;

import app.command.OpenFridge;
import app.techservice.TechService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class OpenFridgeTest {
    @Mock
    private TechService techService;

    @InjectMocks
    private OpenFridge openFridge;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        openFridge = new OpenFridge(techService);
    }

    @Test
    void testExecute() {
        openFridge.execute();

        verify(techService).openFridge();
    }
}
