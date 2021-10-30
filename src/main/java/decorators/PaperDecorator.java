package decorators;

import FlowerStore.Item;

public class PaperDecorator extends ItemDecorator{

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return 13 + super.getPrice();
    }

    public String getDescription() {
        return super.getDescription();
    }
}
