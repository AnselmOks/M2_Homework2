package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Basket {

    private List<Product> products;

    public Basket() {
        products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    private int getNumberOfSpecials() {
        int numberOfSpecials = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                numberOfSpecials++;
            }
        }
        return numberOfSpecials;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
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
        products.clear();
    }
}
