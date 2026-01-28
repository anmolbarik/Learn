import DesignPatterns.SingletonClass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SingletonClass obj1 = SingletonClass.createNewInstance();

        System.out.println(obj1);
        SingletonClass obj2 = SingletonClass.createNewInstance();
        System.out.println(obj2);

        System.out.println(obj1 == obj2); // true

    }
}
