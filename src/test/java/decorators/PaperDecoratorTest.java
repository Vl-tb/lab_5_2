package decorators;

import FlowerStore.Flower;
import FlowerStore.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperDecoratorTest {
    PaperDecorator decorator;
    Flower flower;

    @BeforeEach
    void setUp() {
        int[] color = {128, 0, 0};
        flower = new Flower(55, 40, color, FlowerType.Rose);
        decorator = new PaperDecorator(flower);
    }

    @Test
    void getDescription() {
        assertEquals("Flower(price=55.0, sepalLenght=40.0, color=[128, 0, 0], FlowerType=Rose)",
                decorator.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(68, decorator.getPrice());
    }
}