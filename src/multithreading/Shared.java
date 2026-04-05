package multithreading;

public class Shared {
    synchronized void produce() throws InterruptedException {
        System.out.println("Producer waiting...");
        wait();
        System.out.println("Producer resumed...");
    }

    synchronized void consume() {
        System.out.println("Consumer notifying...");
        notify();
    }
}

 class Chh {
    public static void main(String[] args) {
        Shared obj = new Shared();

        Thread t1 = new Thread(() -> {
            try {
                obj.produce();
            } catch (Exception e) {}
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                obj.consume();
            } catch (Exception e) {}
        });

        t1.start();
        t2.start();
    }
}
