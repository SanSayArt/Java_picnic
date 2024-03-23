package model;

import java.util.Map;

public interface Basket<T> extends Iterable<T> {
    int getSizeBasket();
    void addFruits(T fruits);
    Integer getFruitSum(T fruit);
    Map<T, Integer> getBasket();

}
