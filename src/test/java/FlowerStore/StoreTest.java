package FlowerStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    private Flower flower1;
    private Flower flower2;
    private FlowerPack pack1;
    private FlowerPack pack2;
    private FlowerBucket bucket;
    private Store store;
    private int[] color1 = {128, 0, 0};
    private int[] color2 = {255, 255, 255};

    @BeforeEach
    void setUp() {

        flower1 = new Flower(70, 40, color1, FlowerType.Rose);
        flower2 = new Flower(55, 40, color2, FlowerType.Rose);
        pack1 = new FlowerPack(flower1, 15);
        pack2 = new FlowerPack(flower2, 15);
        bucket = new FlowerBucket();
        store = new Store();
        bucket.addFlowerPack(pack1);
        bucket.addFlowerPack(pack2);
        store.addFlower(flower1);
        store.addFlower(flower2);
        store.addFlowerPack(pack1);
        store.addFlowerPack(pack2);
        store.addFlowerBucket(bucket);
    }

    @Test
    void flowerSearch() {
        assertEquals(store.flowerSearch(FlowerType.Rose, color2, 55, store.getFlowerList()).toString(),
                "[Flower(price=55.0, sepalLenght=40.0, color=[255, 255, 255], FlowerType=Rose)]");
    }

    @Test
    void packSearch() {
        assertEquals(store.packSearch(flower1, 15, store.getFlowerPackList()).toString(),
                "[FlowerPack(flower=Flower(price=70.0, sepalLenght=40.0, color=[128, 0, 0], FlowerType=Rose), amount=15)]");
    }

    @Test
    void bucketSearch() {
        assertEquals(store.bucketSearch(flower2, 1, 5000, store.getFlowerBucketList()).toString(),
                "[FlowerBucket(flowerPackList=[FlowerPack(flower=Flower(price=70.0, sepalLenght=40.0, color=[128, 0, 0], FlowerType=Rose), amount=15), FlowerPack(flower=Flower(price=55.0, sepalLenght=40.0, color=[255, 255, 255], FlowerType=Rose), amount=15)])]");
    }

    @Test
    void search() {
        assertEquals(store.search(flower1, color2, 20, 100, 2000).toString(), "[[], [], []]");
    }
}