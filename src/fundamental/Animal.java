package fundamental;

public abstract class Animal {
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
