package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FruitInBasket implements Basket<Fruit>, Iterable<Fruit>{
    private Map<Fruit, Integer> basket;

    public FruitInBasket() {
            basket = new HashMap<>();
        }

    public FruitInBasket(Map<Fruit, Integer> basket) {
            this.basket = basket;
        }

    public FruitInBasket(List<String> rawData){
            basket = new HashMap<>();
            if (rawData==null) {
                System.err.println("Список имен пуст. Корзина пуста.");
                return;
            }
            for (String fruit: rawData){
                if (!fruit.isEmpty()) {
                    addFruits(Fruit.getFruitInstance(fruit));
                }
            }
        }

        public Map<Fruit, Integer> getBasket() {
            return basket;
        }

        @Override
        public int getSizeBasket() {
            return this.basket.size();
        }

        @Override
        public void addFruits(Fruit fruits) {
            if (fruits == null) throw new RuntimeException("В корзине могут быть только фрукты");
            int count = this.basket.getOrDefault(fruits, 0);
            Integer put = basket.put(fruits, ++count);

        }
        @Override
        public Integer getFruitSum(Fruit fruit) {
            return basket.get(fruit);
        }


        @Override
        public Iterator<Fruit> iterator() {
            return basket.keySet().iterator();
        }}
