package enums;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDemo {

    public static void main(String[] args) {


        MainDemo mainDemo = new MainDemo();
        AmritMood mood = AmritMood.happy;

        if(mood.equals(AmritMood.happy)){
            System.out.println();


        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Executor - - Interface
        //ExecutorService  -- Interface

        //t1
        //t2
        //t3

    }

}
