package fundamental;

public class StaticKeyword {

    // Static Variable (Class variable)
    static int staticCounter = 0;

    // Instance Variable
    int instanceCounter = 0;

    // Constructor to demonstrate static vs instance variables
    public StaticKeyword() {
        staticCounter++;
        instanceCounter++;
        System.out.println("Static Counter: " + staticCounter + " | Instance Counter: " + instanceCounter);
    }

    // Static Method
    public static void printStaticMessage() {
        System.out.println("Static method called. Static Counter: " + staticCounter);
        // Cannot access instanceCounter here
        // System.out.println(instanceCounter); // Compilation error
    }

    // Static Block (executed once when class is loaded)
    static {
        System.out.println("Static block executed - Class is being loaded.");
    }

    // Static Nested Class
    static class StaticNested {
        static void display() {
            System.out.println("Inside static nested class. Accessing staticCounter: " + staticCounter);
            // Cannot access instanceCounter here
        }
    }

    // Main method to demonstrate all static examples
    public static void main(String[] args) {

        System.out.println("Creating first object:");
        StaticKeyword obj1 = new StaticKeyword();

        System.out.println("\nCreating second object:");
        StaticKeyword obj2 = new StaticKeyword();

        System.out.println("\nCalling static method:");
        StaticKeyword.printStaticMessage();

        System.out.println("\nUsing static nested class:");
        StaticKeyword.StaticNested nested = new StaticKeyword.StaticNested();
        //nested.display();
        StaticKeyword.StaticNested.display();
    }
}
