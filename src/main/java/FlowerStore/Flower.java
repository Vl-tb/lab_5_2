package FlowerStore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Arrays;

@Getter
@Setter
@ToString
public class Flower extends Item{
    private double price;
    private double sepalLenght;
    private int[] color;
    private FlowerType FlowerType;

    public Flower(double price, double sepalLenght, int[] color, FlowerType flowerType) {
        this.price = price;
        this.sepalLenght = sepalLenght;
        this.color = color;
        this.FlowerType = flowerType;
    }
    public Flower(FlowerType flowerType) {
        this.FlowerType = flowerType;
    }

    public Flower(){
    }

    public void setColor(int[] color) {
        this.color = Arrays.copyOf(color, this.color.length );
    }

    @Override
    public String getDescription() {
        return toString();
    }
}
