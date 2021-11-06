package user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ReceiverTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Receiver vat1slav;
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        vat1slav = new Receiver();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void update() {
        vat1slav.update("in the post");
        assertEquals("Now the status of your order is in the post", outContent.toString());
    }
}
