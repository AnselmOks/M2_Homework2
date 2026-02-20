package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class Basket {

    private Map<String, List<Product>> products;

    public Basket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts == null) {
            return new ArrayList<>();
        }
        return removedProducts;
    }

    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private long getNumberOfSpecials() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: " + this.getTotalPrice());
        System.out.println("Специальных товаров: " + this.getNumberOfSpecials());
    }

    public boolean isProductInBasket(String name) {
        return (products.containsKey(name));
    }

    public void clearBasket() {
        products.clear();
    }
}
