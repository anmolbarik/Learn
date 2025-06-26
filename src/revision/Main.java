package revision;

class Address {
    String city;
    Address(String city) {
        this.city = city;
    }

   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }*/
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /*Person person = (Person) super.clone();
        person.address = (Address) address.clone();
        return person; */

        return  super.clone();
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Delhi");
        Person p1 = new Person("Anmol", address);
        Person p2 = (Person) p1.clone();

        p2.name = "Barik";
        p2.address.city = "Mumbai";
        p1.address.city = "Khurja";// modifies original's address

        System.out.println(p1.address.city);
        System.out.println(p2.address.city);// Mumbai (shared reference)
    }
}