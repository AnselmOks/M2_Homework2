package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {

    private Product[] products;

    public Basket() {
        products = new Product[5];
    }

    public void addProduct(Product product) {
        boolean productAdded = false;

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                productAdded = true;
                break;
            }
        }
        if (!productAdded) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product == null) break;
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void printBasket() {
        if (products[0] == null) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product == null) break;
            System.out.println(product.getName() + ": " + product.getPrice());
        }
        System.out.println("Итого: " + this.getTotalPrice());
    }

    public boolean isProductInBasket(String name) {
        boolean isProductInBasket = false;
        for (Product product : products) {
            if (product == null) break;
            isProductInBasket = name.equals(product.getName());
            if (isProductInBasket) break;
        }
        return isProductInBasket;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

}
