package order;

import FlowerStore.*;

import java.util.ArrayList;
import java.util.List;

public class QuickOrder {

    public static Order createOrder(){
        Flower flower1;
        Flower flower2;
        List<Item> items = new ArrayList<>();
        int[] color1 = {128, 0, 0};
        int[] color2 = {255, 255, 255};

        flower1 = new Flower(70, 40, color1, FlowerType.Rose);
        flower2 = new Flower(55, 40, color2, FlowerType.Rose);

        FlowerPack pack1 = new FlowerPack(flower1, 15);
        FlowerPack pack2 = new FlowerPack(flower2, 15);

        FlowerBucket bucket = new FlowerBucket();

        bucket.addFlowerPack(pack1);
        bucket.addFlowerPack(pack2);

        items.add(bucket);
        Order order = new Order();
        order.setItems(items);
        return order;
    }

}
