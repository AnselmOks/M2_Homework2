package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Basket basket1 = new Basket();
        basket1.addProduct(new SimpleProduct("Помидор", 300));
        basket1.addProduct(new FixPriceProduct("Груша"));
        basket1.addProduct(new FixPriceProduct("Мандарин"));
        basket1.addProduct(new DiscountedProduct("Лук",100,20));
        basket1.addProduct(new DiscountedProduct("Арбуз",450,10));

        basket1.addProduct(new SimpleProduct("Морковь", 300));

        basket1.printBasket();

        System.out.println("Итого: " + basket1.getTotalPrice());

        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Яблоко"));

        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Арбуз"));

        basket1.clearBasket();

        basket1.printBasket();

        System.out.println("Итого: " + basket1.getTotalPrice());

    }
}