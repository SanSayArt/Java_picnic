package view;

import model.Basket;
import model.Fruit;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class CalcFruitRate implements Calc<Basket> {
    private static boolean ascending = false;

    public CalcFruitRate() {
    }

    public CalcFruitRate(boolean ascending) {CalcFruitRate.ascending = ascending;}

    @Override
    public void calc(Basket basket) {
        Map<Fruit, Integer> sorted = sortBasket(basket);
        for (Fruit fruit: sorted.keySet()) {
            System.out.printf("'%s' = %s%n",fruit.getName(),basket.getFruitSum(fruit));
        }

    }
    private Map<Fruit, Integer> sortBasket(Basket<Fruit> basket){
        Map<Fruit, Integer> sorted = basket.getBasket();

        Object LinkedHashMap;
        if (!ascending) {
            sorted = sorted
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        } else {
            sorted = sorted
                    .entrySet()
                    .stream()
                    .sorted(comparingByValue())
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        }
        return sorted;
    }
    public static void setAscending(boolean ascending){ CalcFruitRate.ascending = ascending;}
}
