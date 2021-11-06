package order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickOrderTest {
    Order order;
    @BeforeEach
    void setUp() {
        order = QuickOrder.createOrder();
    }

    @Test
    void quickOrder() {
        assertEquals(order.toString(), "Order(users=[], items=[FlowerBucket(flowerPackList=[FlowerPack" +
                "(flower=Flower(price=70.0, sepalLenght=40.0, color=[128, 0, 0], FlowerType=Rose), amount=15), " +
                "FlowerPack(flower=Flower(price=55.0, sepalLenght=40.0, color=[255, 255, 255], FlowerType=Rose), " +
                "amount=15)])])");
    }
}