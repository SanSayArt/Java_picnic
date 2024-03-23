package view;

import model.Basket;
import model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class CalcAllFruit implements Calc<Basket>{
    @Override
    public void calc(Basket basket) {
        List<String> allFruits = getAllFruits(basket);
        for (String fruit: allFruits) System.out.println(fruit);

    }
    private List<String> getAllFruits(Basket<Fruit> basket) {
        List<String> result = new ArrayList<>();
        for (Fruit fruit : basket) {
            result.add(String.format("%s - %s шт.", fruit.getName(), basket.getFruitSum(fruit)));

        }
        return result;
    }
}
