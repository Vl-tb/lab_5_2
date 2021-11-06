package order;

import FlowerStore.Item;
import lombok.Getter;
import lombok.ToString;
import user.Sender;
import user.User;

import java.util.ArrayList;
import java.util.List;
@Getter @ToString
public class Order {
    private List<User> users = new ArrayList<>();
    private List<Object> items = new ArrayList<>();

    public void addUser(User user) {
        user.setId(users.size());
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void notifyUsers() {
        for (int i=0; i< users.size(); i++) {
            User user = users.get(i);
            if (user instanceof Sender) {
                users.get(i).update("on the post");
            }
            else {
                users.get(i).update("sent");
            }

        }
    }

    public void order() {
        System.out.println("Order is processing...");
        notifyUsers();
    }

    public void setItems(List<Item> storeItems) {
        for (int i=0; i< storeItems.size(); i++) {
            items.add(storeItems.get(i));
        }
    }
}
