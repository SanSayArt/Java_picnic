package model;

import java.util.Comparator;

public class FruitComp implements Comparator<Fruit> {
    @Override
    public int compare(Fruit f1, Fruit f2) {
        return Integer.compare(f1.getFruitNameLength(),f2.getFruitNameLength());
    }
}
