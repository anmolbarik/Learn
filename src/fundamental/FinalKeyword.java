package fundamental;

// final class cannot be extended
final class FinalClassExample {
    void show() {
        System.out.println("Inside final class");
    }
}

// This class demonstrates use of final keyword
public class FinalKeyword {

    // final variable (constant)
    final int finalInstanceVar = 100;

    // static final variable (constant shared across all instances)
    static final double PI = 3.14159;

    // instance variable
    int normalVar = 10;

    // final method cannot be overridden
    public final void displayMessage() {
        System.out.println("This is a final method");
    }

    // constructor
    public FinalKeyword() {
        // finalInstanceVar = 200; // this will cause compile-time error
    }

    // method demonstrating final parameter
    public void calculateArea(final int radius) {
        // radius = radius + 1; // not allowed, final parameter cannot be reassigned
        double area = PI * radius * radius;
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        FinalKeyword obj = new FinalKeyword();

        System.out.println("Final instance variable: " + obj.finalInstanceVar);
        System.out.println("Static final variable PI: " + FinalKeyword.PI);

        obj.displayMessage();
        obj.calculateArea(5);

        FinalClassExample finalObj = new FinalClassExample();
        finalObj.show();
    }
}
