package FlowerStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {
    private Flower flower1;
    private Flower flower2;
    private FlowerPack pack1;
    private FlowerPack pack2;
    private FlowerBucket bucket;

    @BeforeEach
    void setUp() {
        int[] color1 = {128, 0, 0};
        int[] color2 = {255, 255, 255};
        flower1 = new Flower(70, 40, color1, FlowerType.Rose);
        flower2 = new Flower(55, 40, color2, FlowerType.Rose);
        pack1 = new FlowerPack(flower1, 15);
        pack2 = new FlowerPack(flower2, 15);
        bucket = new FlowerBucket();
        bucket.addFlowerPack(pack1);
        bucket.addFlowerPack(pack2);
    }

    @Test
    void addFlowerPack() {
        assertEquals(bucket.getFlowerPackList().get(0), pack1);
        assertEquals(bucket.getFlowerPackList().get(1), pack2);
    }

    @Test
    void getPrice() {
        assertEquals(bucket.getPrice(), 1875);
    }
}