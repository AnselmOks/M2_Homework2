package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {

    private Product[] products;

    public Basket() {
        products = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    private int getNumberOfSpecials() {

        int numberOfSpecials = 0;

        for (Product product : products) {
            if (product != null) {
                if (product.isSpecial()) {
                    numberOfSpecials++;
                }
            }
        }

        return numberOfSpecials;

    }

    public void printBasket() {

        if (products[0] == null) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + this.getTotalPrice());
        System.out.println("Специальных товаров: " + this.getNumberOfSpecials());
    }

    public boolean isProductInBasket(String name) {
        boolean isProductInBasket = false;
        for (Product product : products) {
            if (product != null) {
                isProductInBasket = name.equals(product.getName());
            }
            if (isProductInBasket) {
                break;
            }
        }
        return isProductInBasket;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
