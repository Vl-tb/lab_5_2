package delivery;

import FlowerStore.Item;

import java.util.List;

public interface Delivery {
    void deliver(List<Item> items);
}
