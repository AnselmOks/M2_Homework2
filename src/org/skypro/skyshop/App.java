package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.SearchEngine;
import org.skypro.skyshop.service.Searchable;

public class App {

    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine(15);

        searchEngine.add(new SimpleProduct("Помидор", 300));
        searchEngine.add(new FixPriceProduct("Груша"));
        searchEngine.add(new FixPriceProduct("Мандарин"));
        searchEngine.add(new DiscountedProduct("Лук", 100, 20));
        searchEngine.add(new DiscountedProduct("Арбуз", 450, 10));
        searchEngine.add(new SimpleProduct("Морковь", 300));

        searchEngine.add(new Article("Помидор", "Помидор (томат) — это съедобный плод растения семейства паслёновых"));
        searchEngine.add(new Article("Польза помидора", """
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

        printSearchResult(searchEngine.search("Помидор"));
        printSearchResult(searchEngine.search("Лук"));
        printSearchResult(searchEngine.search("DeepSeek"));
    }

    public static void printSearchResult(Searchable[] foundItems) {
        for (Searchable item : foundItems) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }

}