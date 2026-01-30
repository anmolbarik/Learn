package LambdaDemo;

public class MainDemoClass {

    public static void main(String[] args) {

        InterfaceDemo obj = ()-> System.out.println("Hello");

        obj.display();
    }
}
