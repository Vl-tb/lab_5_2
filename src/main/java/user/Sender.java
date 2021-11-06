package user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Sender implements User{
    private int id = 0;

    @Override
    public void update(String status) {
        System.out.printf("Now the status of your order is %s", status);
    }
}
