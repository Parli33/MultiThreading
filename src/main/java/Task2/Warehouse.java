package Task2;

import java.util.LinkedList;
import java.util.List;

record Order(int orderId, String shoesType, int orderedQuantity) {
}

public class Warehouse {
    public static final List<String> productsList = List.of("Sneakers", "Boots", "Sandals");
    private final LinkedList<Order> orders = new LinkedList<>();

    public synchronized void receiveOrder(Order order) throws InterruptedException {
        int maxCapacity = 10;
        while (orders.size() >= maxCapacity) {
            wait();
        }
        orders.add(order);
        System.out.println("Received order: " + order);
        notifyAll();
    }

    public synchronized void fulfillOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            wait();
        }
        Order order = orders.removeFirst();
        System.out.println("Fulfilled order: " + order);
        notifyAll();
    }

}
