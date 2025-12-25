package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Basket basket1 = new Basket();
        basket1.addProduct(new Product("Морковь", 100));
        basket1.addProduct(new Product("Манго", 250));
        basket1.addProduct(new Product("Салат", 120));
        basket1.addProduct(new Product("Яблоко", 150));
        basket1.addProduct(new Product("Груша", 200));

        basket1.addProduct(new Product("Арбуз", 300));

        basket1.printBasket();

        System.out.println("Итого: " + basket1.getTotalPrice());

        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Яблоко"));

        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Арбуз"));

        basket1.clearBasket();

        basket1.printBasket();

        System.out.println("Итого: " + basket1.getTotalPrice());

        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Яблоко"));

    }
}