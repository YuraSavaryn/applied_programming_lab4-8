package app.command;

import app.command.MakeSaladCommand;
import app.saladservice.SaladService;
import app.techservice.TechService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MakeSaladCommandTest {

    @Mock
    private SaladService saladService;

    @Mock
    private TechService techService;

    @Mock
    private Scanner scan;

    @InjectMocks
    private MakeSaladCommand makeSaladCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        makeSaladCommand = new MakeSaladCommand(saladService, techService, scan);
    }

    @Test
    void testExecute() {
        when(scan.nextLine()).thenReturn("Cezar");

        makeSaladCommand.execute();

        verify(saladService).makeSalad("Cezar", techService);
    }
}
