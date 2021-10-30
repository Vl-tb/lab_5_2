package delivery;

import FlowerStore.Flower;
import FlowerStore.FlowerType;
import FlowerStore.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostDeliveryStrategyTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    PostDeliveryStrategy delivery;
    Flower flower;
    List<Item> items;

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
        delivery = new PostDeliveryStrategy();
        System.setOut(new PrintStream(outContent));
        int[] color = {128, 0, 0};
        flower = new Flower(55, 40, color, FlowerType.Rose);
        items.add(0, flower);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void deliver() {
        delivery.deliver(items);
        assertEquals("Items will be delivered by post.", outContent.toString());
    }
}