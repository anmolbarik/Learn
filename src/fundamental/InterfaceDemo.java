package fundamental;

public interface InterfaceDemo {

    static void display(){
        System.out.println("Static method in Interface");
    }

    default void show(){
        System.out.println("Default method in Interface");
    }
}

class Democlass implements InterfaceDemo {
    @Override
    public void show() {
        System.out.println("My  method in Interface");
    }

    public void show(int i){
        System.out.println("My  Overloaded in Interface");
    }

    public static void main(String[] args) {

        Democlass obj = new Democlass();
        obj.show(); // Calling default method
    }

}

