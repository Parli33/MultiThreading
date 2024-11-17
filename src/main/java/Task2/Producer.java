package Task2;

import java.util.Random;

public class Producer implements Runnable {
    private final Warehouse warehouse;
    private final int ordersCount;

    public Producer(Warehouse warehouse, int ordersCount) {
        this.warehouse = warehouse;
        this.ordersCount = ordersCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < ordersCount; i++) {
            try {
                String shoesType = Warehouse.productsList.get(new Random().nextInt(Warehouse.productsList.size()));
                Order order = new Order(i, shoesType, new Random().nextInt(25));
                warehouse.receiveOrder(order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
