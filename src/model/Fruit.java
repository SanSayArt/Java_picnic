package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fruit implements Fruits, Comparable<Fruits> {
    private String name;
    private final int nameLength;

    private static Map<String, Fruit> fruits;
    static {
        fruits = new HashMap<>();
    }

    private Fruit(String name) {
        this.name = name;
        nameLength = name.length();
    }

    /**
     * Метод фабрика
     * @param name строка - название фрукта
     * @return экземпляр класса Fruits
     */
    public static Fruit getFruitInstance(String name){
        return fruits.getOrDefault(name, new Fruit(name));
    }

    public String getName() {
        return name;
    }

    @Override
    public int getFruitNameLength() {
        return nameLength;
    }

    @Override
    public int compareTo(Fruits o) {
        int otherNameLength = o.getFruitNameLength();
        return Integer.compare(this.nameLength, otherNameLength);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Плод %s",name);
    }
}
