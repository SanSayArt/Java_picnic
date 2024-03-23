package view;

import model.Basket;
import model.Fruit;
import model.FruitComp;

import java.util.Optional;

public class CalcLongName implements Calc<Basket> {
    @Override
    public void calc(Basket basket) {
        Optional<Fruit> maxFruit = basket.getBasket().keySet().stream().max(new FruitComp());
        System.out.printf("Самое длинное название - %s, его длина %s символов%n",
                maxFruit.get().getName(),maxFruit.get().getFruitNameLength());
    }
}
