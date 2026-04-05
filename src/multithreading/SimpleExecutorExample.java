package multithreading;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorExample {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> {System.out.println("Task running via the Executor interface!");});


    }
}