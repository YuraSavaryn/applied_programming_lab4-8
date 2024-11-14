package app.command;

import app.command.ExitCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitCommandTest {
    private ExitCommand exitCommand;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        exitCommand = new ExitCommand();

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecute() {
        exitCommand.execute();

        assertEquals("Exit from program...", outputStreamCaptor.toString().trim());
    }
}
