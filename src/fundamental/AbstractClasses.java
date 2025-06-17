package fundamental;


public class AbstractClasses {
    
    public static void main(String[] args) {
        System.out.println("=== Abstract Classes in Java ===\n");
        
        // Cannot instantiate abstract class
        // Shape shape = new Shape(); // This would cause a compilation error
        
        // Create instances of concrete subclasses
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        // Call methods
        System.out.println("--- Circle ---");
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        circle.display();
        
        System.out.println("\n--- Rectangle ---");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        rectangle.display();
        
        // Demonstrate abstract class with constructor
        System.out.println("\n--- Animal Abstract Class ---");
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        
        dog.eat();
        dog.sleep();
        dog.makeSound();
        System.out.println("Dog age in human years: " + dog.calculateAgeInHumanYears());
        
        cat.eat();
        cat.sleep();
        cat.makeSound();
        System.out.println("Cat age in human years: " + cat.calculateAgeInHumanYears());
        
        // Demonstrate abstract class with instance variables and constructors
        System.out.println("\n--- Employee Abstract Class ---");
        Employee fullTimeEmployee = new FullTimeEmployee("John Doe", 101, 5000.0);
        Employee partTimeEmployee = new PartTimeEmployee("Jane Smith", 102, 20.0, 80);
        
        System.out.println(fullTimeEmployee.getDetails());
        System.out.println("Salary: $" + fullTimeEmployee.calculateSalary());
        
        System.out.println(partTimeEmployee.getDetails());
        System.out.println("Salary: $" + partTimeEmployee.calculateSalary());
    }
}


abstract class Shape {
    // Abstract methods (must be implemented by subclasses)
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Concrete method (inherited by all subclasses)
    public void display() {
        System.out.println("This is a shape with area " + calculateArea() + 
                           " and perimeter " + calculatePerimeter());
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    // Additional method specific to Circle
    public double getDiameter() {
        return 2 * radius;
    }
}


class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}


abstract class Animal {
    protected String name;
    protected int age;
    
    // Constructor in abstract class
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete methods
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    // Abstract method
    public abstract void makeSound();
    
    // Abstract method with implementation in subclasses
    public abstract int calculateAgeInHumanYears();
}


class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age); // Call to parent constructor
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
    
    @Override
    public int calculateAgeInHumanYears() {
        return age * 7; // Simple conversion for dogs
    }
}


class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age); // Call to parent constructor
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
    
    @Override
    public int calculateAgeInHumanYears() {
        return age * 5; // Simple conversion for cats
    }
}


abstract class Employee {
    protected String name;
    protected int id;
    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    // Concrete method
    public String getDetails() {
        return "Employee [ID: " + id + ", Name: " + name + "]";
    }
    
    // Abstract method
    public abstract double calculateSalary();
}


class FullTimeEmployee extends Employee {
    private double monthlySalary;
    
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
    
    @Override
    public String getDetails() {
        return "Full-time " + super.getDetails();
    }
}


class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    
    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    
    @Override
    public String getDetails() {
        return "Part-time " + super.getDetails();
    }
}