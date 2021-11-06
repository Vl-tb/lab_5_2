package user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Sender vat1slav;
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        vat1slav = new Sender();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void update() {
        vat1slav.update("sent");
        assertEquals("Now the status of your order is sent", outContent.toString());
    }
}
