package payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    PayPalPaymentStrategy pay;

    @BeforeEach
    void setUp() {
        pay = new PayPalPaymentStrategy();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void pay() {
        pay.pay(10);
        assertEquals("Payment by PayPal is processing...", outContent.toString());
    }
}