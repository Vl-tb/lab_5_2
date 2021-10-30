package FlowerStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {
    private Flower flower;
    private FlowerPack pack;
    @BeforeEach
    void setUp() {
        int[] color = {128, 0, 0};
        flower = new Flower(55, 40, color, FlowerType.Rose);
        pack = new FlowerPack(flower, 15);
    }

    @Test
    void getPrice() {
        assertEquals(pack.getPrice(), 825);
    }

    @Test
    void getFlower() {
        assertEquals(pack.getFlower(), flower);
    }
}