import FlowerStore.*;

import static FlowerStore.FlowerType.*;

public class Main {
    public static void main(String[] args) {
        Flower flower1;
        Flower flower2;
        FlowerPack pack1;
        FlowerPack pack2;
        FlowerBucket bucket;
        Store store = new Store();
        int[] color1 = {128, 0, 0};
        int[] color2 = {255, 255, 255};
        flower1 = new Flower(70, 40, color1, FlowerType.Rose);
        flower2 = new Flower(55, 40, color2, FlowerType.Rose);
        pack1 = new FlowerPack(flower1, 15);
        pack2 = new FlowerPack(flower2, 15);
        bucket = new FlowerBucket();
        bucket.addFlowerPack(pack1);
        bucket.addFlowerPack(pack2);
        store.addFlower(flower1);
        store.addFlower(flower2);
        store.addFlowerPack(pack1);
        store.addFlowerPack(pack2);
        store.addFlowerBucket(bucket);

        System.out.println(store.flowerSearch(FlowerType.Rose, color2, 55, store.getFlowerList()));
        System.out.println(store.packSearch(flower1, 15, store.getFlowerPackList()));
        System.out.println(store.bucketSearch(flower2, 1, 5000, store.getFlowerBucketList()));
        System.out.println(store.search(flower1, color2, 20, 100, 2000));
    }

}