package control;

import model.Basket;
import model.Fruit;
import model.FruitInBasket;
import view.*;

public class Control {
    private Calc<Basket> calc;
    private Basket<Fruit> basket;
    private static String menuPoint = " 1 - Вывести содержимоле корзины %n" +
            "2 - Вывести список всего фруктов в корзине %n"+
            "3 - Вывести самое длинное название фрукта в корзине %n"+
            "4 - Вывести самые популярные фрукты в корзине %n"+
            "5 - Вывести самые не популярные фрукты в корзине %n"+
            "0 - Выйти из приложения %n"+
            "Введите номер операции: ";
    private GetSelect getSelect;

    public Control() {
        basket = new FruitInBasket(new LoadFromFile("src/resources/input.txt").getRawFruits());
    }

    public void run(){
        int command = 10;
        getSelect = new GetSelect();
        while (command!=0){
            command = getSelect.getIntegerSel(menuPoint);
            calc = switch (command) {
                case 1 -> new CalcAllFruit();
                case 2 -> new CalcCountFruit();
                case 3 -> new CalcLongName();
                case 4 -> new CalcFruitRate(false);
                case 5 -> new CalcFruitRate(true);
                default -> null;
            };
            if (calc!=null) {
                calc.calc(basket);
            }
        }
        getSelect.closeScan();

    }
}
