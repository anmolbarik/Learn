package fundamental;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class EqualsAndHashCode {

    // Custom class with overridden equals() and hashCode()
    static class Person {
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Overriding equals() for logical equality
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // same reference
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return id == person.id && Objects.equals(name, person.name);
        }

        // Overriding hashCode() to follow contract with equals()
        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static void main(String[] args) {
        // equals() without overriding: compares memory address
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("Using equals() on String: " + s1.equals(s2)); // true
        System.out.println("Using == on String: " + (s1 == s2)); // false

        // Without overriding equals/hashCode
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println("Default equals(): " + o1.equals(o2)); // false
        System.out.println("Default hashCode(): " + o1.hashCode() + ", " + o2.hashCode());

        // With custom class: equality based on id and name
        Person p1 = new Person(1, "Alice");
        Person p2 = new Person(1, "Alice");

        System.out.println("Custom equals(): " + p1.equals(p2)); // true
        System.out.println("Custom hashCode(): " + p1.hashCode() + ", " + p2.hashCode()); // same

        // HashSet Example: avoid duplicate entries
        HashSet<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2); // not added if equals & hashCode are correct

        System.out.println("HashSet size (should be 1): " + people.size());

        // HashMap Example
        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "Engineer");
        System.out.println("Get from HashMap using equal object: " + map.get(p2)); // "Engineer"
    }
}
