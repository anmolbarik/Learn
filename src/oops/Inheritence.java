package oops;

/**
 * This class demonstrates inheritance, method overriding, and polymorphism in Java
 */
public class Inheritence {

    public static void main(String[] args) {
        System.out.println("=== Inheritance, Method Overriding, and Polymorphism ===\n");

        // Create instances of parent and child classes
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        // Call methods on specific objects
        System.out.println("--- Direct Method Calls ---");
        animal.eat();
        animal.move();

        dog.eat();    // Overridden method
        dog.move();   // Inherited method
        dog.bark();   // Dog-specific method

        cat.eat();    // Overridden method
        cat.move();   // Overridden method
        cat.meow();   // Cat-specific method

        // Polymorphism - treating child classes as parent type
        System.out.println("\n--- Polymorphism ---");

        // Array of Animal references, but holding different types
        Animal[] animals = new Animal[3];
        animals[0] = new Animal();
        animals[1] = new Dog();     // Dog treated as Animal
        animals[2] = new Cat();     // Cat treated as Animal

        // Polymorphic method calls - method called depends on actual object type
        for (Animal a : animals) {
            System.out.print("Object type: " + a.getClass().getSimpleName() + " - ");
            a.eat();  // Calls appropriate version based on actual object type
            a.move(); // Demonstrates polymorphic behavior

            // We can't call bark() or meow() here because Animal doesn't define these methods
            // a.bark(); // Compilation error

            // Using instanceof to safely call specific methods
            if (a instanceof Dog) {
                Dog d = (Dog) a;    // Downcasting
                d.bark();
            } else if (a instanceof Cat) {
                Cat c = (Cat) a;    // Downcasting
                c.meow();
            }
        }

        // Method overloading example
        System.out.println("\n--- Method Overloading ---");
        Dog husky = new Dog();
        husky.setInfo("Husky", 3);
        husky.displayInfo();

        // Demonstrate super keyword
        System.out.println("\n--- Using super Keyword ---");
        dog.showAnimalType();
    }
}

class Animal {
    protected String type = "Generic Animal";

    void eat() {
        System.out.println("This animal eats food.");
    }

    void move() {
        System.out.println("This animal moves.");
    }

    // Method to be called via super
    void showType() {
        System.out.println("This is a " + type);
    }
}

class Dog extends Animal {
    private String breed;
    private int age;

    // Constructor
    public Dog() {
        this.type = "Dog"; // Accessing protected field from parent
    }

    // Method overriding - changing behavior of parent method
    @Override
    void eat() {
        System.out.println("Dog eats meat.");
    }

    // Dog-specific method
    void bark() {
        System.out.println("Dog barks: Woof!");
    }

    // Method that uses super to call parent method
    void showAnimalType() {
        super.showType(); // Call parent's method
        System.out.println("This is specifically a " + type);
    }

    // Method overloading - same name, different parameters
    void setInfo(String breed) {
        this.breed = breed;
    }

    void setInfo(String breed, int age) {
        this.breed = breed;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Dog breed: " + breed + ", Age: " + age);
    }
}

class Cat extends Animal {
    // Constructor
    public Cat() {
        this.type = "Cat";
    }

    // Method overriding
    @Override
    void eat() {
        System.out.println("Cat eats fish.");
    }

    // Method overriding
    @Override
    void move() {
        System.out.println("Cat moves gracefully.");
    }

    // Cat-specific method
    void meow() {
        System.out.println("Cat meows: Meow!");
    }
}
