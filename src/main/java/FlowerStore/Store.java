package FlowerStore;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Store {
    private List<Flower> flowerList = new ArrayList<Flower>();
    private List<FlowerPack> flowerPackList = new ArrayList<FlowerPack>();
    private List<FlowerBucket> flowerBucketList = new ArrayList<FlowerBucket>();

    public Store() {
    }

    public void addFlower(Flower flower) {
        flowerList.add(flower);
    }

    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPackList.add(flowerPack);
    }

    public void addFlowerBucket(FlowerBucket flowerBucket) {
        flowerBucketList.add(flowerBucket);
    }

    public List<Object> flowerSearch(FlowerType flower, int[] color, double price, List<Flower> from){
        List<Object> resultList = new ArrayList<Object>();
        for (int i=0; i<from.size(); i++) {
            Flower flowObj = from.get(i);
            if (flowObj.getFlowerType() == flower &&
                    flowObj.getColor() == color &&
                    flowObj.getPrice() == price) {
                resultList.add(flowObj);
            }
        }
        return resultList;
    }

    public List<Object> packSearch(Flower flower, int amount, List<FlowerPack> from){
        List<Object> resultList = new ArrayList<Object>();
        for (int i=0; i<from.size(); i++) {
            FlowerPack packObj = from.get(i);
            if (packObj.getFlower() == flower &&
                    packObj.getAmount() >= amount) {
                resultList.add(packObj);
            }
        }
        return resultList;
    }

    public List<Object> bucketSearch(Flower flower, int amount, double price, List<FlowerBucket> from) {
        List<Object> resultList = new ArrayList<Object>();
        for (int i = 0; i < from.size(); i++) {
            FlowerBucket bucketObj = from.get(i);
            List<Object> packs;
            packs = packSearch(flower, amount, bucketObj.getFlowerPackList());
            if (packs.size() != 0 && bucketObj.getPrice() <= price) {
                resultList.add(bucketObj);
            }
        }
        return resultList;
    }


    public Object search(Flower flower, int[] color, int amount, double price, double priceBucket) {
        List<Object> resultList = new ArrayList<Object>();
        List<Object> flowers = flowerSearch(flower.getFlowerType(), color, price, this.flowerList);
        List<Object> packs = packSearch(flower, amount, this.flowerPackList);
        List<Object> buckets = bucketSearch(flower, amount, priceBucket, this.flowerBucketList);
        resultList.add(flowers);
        resultList.add(packs);
        resultList.add(buckets);
        return resultList;
    }
}
