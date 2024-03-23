package view;

import model.Basket;

public class CalcCountFruit implements Calc<Basket> {
    @Override
    public void calc(Basket basket) {
        System.out.printf("Всего фруктов - %s%n", basket.getSizeBasket());
    }
}
