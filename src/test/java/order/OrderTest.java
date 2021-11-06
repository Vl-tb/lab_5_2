package order;

import FlowerStore.Flower;
import FlowerStore.FlowerType;
import FlowerStore.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Receiver;
import user.Sender;
import user.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    User vat1slav;
    User elementary;
    Flower flower1;
    Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        vat1slav = new Sender();
        elementary = new Receiver();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void addUser() {
        order.addUser(vat1slav);
        assertEquals(order.getUsers().toString(), "[Sender(id=0)]");
        order.addUser(elementary);
        assertEquals(order.getUsers().toString(), "[Sender(id=0), Receiver(id=1)]");
        assertEquals(vat1slav.getId(), 0);
        assertEquals(elementary.getId(), 1);
    }

    @Test
    void removeUser() {
        order.addUser(vat1slav);
        order.addUser(elementary);
        order.removeUser(vat1slav);
        assertEquals(order.getUsers().toString(), "[Receiver(id=1)]");
    }

    @Test
    void notifyUsers() {
        order.addUser(vat1slav);
        order.addUser(elementary);
        order.notifyUsers();
        assertEquals("Now the status of your order is on the postNow the status of your order is sent",
                outContent.toString());
    }

    @Test
    void order() {
        order.addUser(vat1slav);
        order.order();
        assertEquals("Order is processing...\n" +
                "Now the status of your order is on the post", outContent.toString());
    }

    @Test
    void setItems() {
        int[] color = {128, 0, 0};
        flower1 = new Flower(55, 40, color, FlowerType.Rose);
        List<Item> items = new ArrayList<>();
        items.add(flower1);
        order.setItems(items);
        assertEquals("[Flower(price=55.0, sepalLenght=40.0, color=[128, 0, 0], FlowerType=Rose)]",
                order.getItems().toString());
    }
}
