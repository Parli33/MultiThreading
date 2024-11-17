package Task1;

public class Main {
    public static void main(String[] args) {
        EvenNumbersThread evenThread = new EvenNumbersThread();
        evenThread.start();

        Thread oddThread = new Thread(new OddNumbersRunnable());
        oddThread.start();
    }
}

class EvenNumbersThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            System.out.println("Even: " + i);
        }
    }
}

class OddNumbersRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println("Odd: " + i);
        }
    }
}