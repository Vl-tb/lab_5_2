package delivery;

import FlowerStore.Item;

import java.util.List;

public class PostDeliveryStrategy implements Delivery{

    @Override
    public void deliver(List<Item> items) {
        System.out.print("Items will be delivered by post.");
    }
}
