package payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardlPaymentTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    CreditCardPaymentStrategy pay;

    @BeforeEach
    void setUp() {
        pay = new CreditCardPaymentStrategy();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void pay() {
        pay.pay(10);
        assertEquals("Payment by credit card is processing...", outContent.toString());
    }
}