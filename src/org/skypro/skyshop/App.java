package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.BestResultNotFound;
import org.skypro.skyshop.service.SearchEngine;
import org.skypro.skyshop.service.Searchable;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Basket basket1 = new Basket();

        basket1.addProduct(new SimpleProduct("Помидор", 300));
        basket1.addProduct(new DiscountedProduct("Помидор", 300, 10));
        basket1.addProduct(new FixPriceProduct("Груша"));
        basket1.addProduct(new FixPriceProduct("Мандарин"));
        basket1.addProduct(new DiscountedProduct("Лук", 100, 20));
        basket1.addProduct(new DiscountedProduct("Арбуз", 450, 10));
        basket1.addProduct(new SimpleProduct("Морковь", 300));

        List<Product> deletedProducts = basket1.deleteProduct("Помидор");
        System.out.println(deletedProducts);
        basket1.printBasket();

        deletedProducts = basket1.deleteProduct("Репа");
        if (deletedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket1.printBasket();

        System.out.println("Итого: " + basket1.getTotalPrice());

        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Яблоко"));
        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Репа"));
        System.out.println("Товар в корзине: " + basket1.isProductInBasket("Арбуз"));

        basket1.clearBasket();

        basket1.printBasket();

        SearchEngine searchEngine = new SearchEngine();

        try {
            searchEngine.add(new SimpleProduct("Базилик", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            searchEngine.add(new SimpleProduct(" ", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            searchEngine.add(new DiscountedProduct("Репа", 1000, 1000));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        searchEngine.add(new SimpleProduct("Помидор", 300));
        searchEngine.add(new FixPriceProduct("Груша"));
        searchEngine.add(new FixPriceProduct("Мандарин"));
        searchEngine.add(new DiscountedProduct("Лук", 100, 20));
        searchEngine.add(new DiscountedProduct("Арбуз", 450, 10));
        searchEngine.add(new SimpleProduct("Морковь", 300));

        searchEngine.add(new Article("Помидор", "Помидор (томат) — это съедобный плод растения семейства паслёновых"));
        searchEngine.add(new Article("Польза Помидора", """
                Помидоры полезны благодаря антиоксиданту ликопину
                (профилактика рака и сердечных заболеваний), витаминам (C, A, K, группы B) для иммунитета,
                зрения и нервной системы"""));
        searchEngine.add(new Article("Рецепт яичницы с луком", """
                Лук - 1 шт.
                Помидоры - 2–3 шт.
                Яйца - 3 шт.
                Соль по вкусу"""));
        searchEngine.add(new Article("Какие продукты относятся к пасленовым?", """
                Зеленые плоды пасленовых. Помидоры, баклажаны, перец и так далее"""));
        searchEngine.add(new Article("Синьор Помидор", """
                Острый и ароматный тайский суп с морепродуктами, грибами и кокосовым молоком.
                Подается с рисом, лаймом и свежей кинзой – взрыв вкусов!"""));
        searchEngine.add(new Article("DeepSeek", """
                Семейство передовых больших языковых моделей (LLM) и
                компания-разработчик из Китая"""));

        //Поиск всех элементов
        printSearchResult(searchEngine.search("Помидор"));

        //Поиск наиболее подходящего
        System.out.println("--------------------------------------------------------");
        try {
            Searchable bestResult = searchEngine.searchBestResult("Помидор");
            System.out.println(bestResult.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestResult = searchEngine.searchBestResult("Репа");
            System.out.println(bestResult.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printSearchResult(List<Searchable> foundItems) {
        for (Searchable item : foundItems) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }

}