package multithreading;

public class ThreadDemo implements Runnable {

    Thread t1;

    public ThreadDemo(Thread t1) {
        this.t1 = new Thread();
    }

    public void run() {
        try {
            System.out.println("t2 waiting for t1 to finish...");
            t1.join();   // t2 waits for t1
            System.out.println("t2 started after t1 finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class demo extends Thread {
    public void run() {
        try {
            System.out.println("t1 started");
            Thread.sleep(3000);
            System.out.println("t1 finished");
        } catch (Exception e) {}
    }
}

class Tidu {
    public static void main(String[] args) {
        Thread t1 = new demo();
        Thread t2 = new Thread(new ThreadDemo(t1));

        t1.start();
        t2.start();
    }
}