package Task2;

public class Consumer implements Runnable {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                warehouse.fulfillOrder();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
