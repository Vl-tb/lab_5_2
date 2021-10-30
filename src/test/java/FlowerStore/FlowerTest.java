package FlowerStore;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower flower;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        int[] color = {128, 0, 0};
        flower = new Flower(55, 40, color, FlowerType.Rose);
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(flower.getPrice(), 55);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        int[] color = {128, 0, 0};
        assertArrayEquals(flower.getColor(), color);
    }
}