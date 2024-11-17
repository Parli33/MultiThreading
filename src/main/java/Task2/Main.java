package Task2;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        int orderCount = 20;

        Thread Producer = new Thread(new Producer(warehouse, orderCount));
        Producer.start();

        for (int i = 0; i < (orderCount / 5); i++) {
            new Thread(new Consumer(warehouse)).start();
        }
    }
}
