package org.skypro.skyshop.service;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public Set<Searchable> search(String searchItem) {
        return items.stream()
                .filter(s -> s.getSearchItem().contains(searchItem))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new CustomSearchComparator().reversed())));
    }

    public Searchable searchBestResult(String searchString) throws BestResultNotFound {

        Searchable foundItem = null;
        int maxInclude = 0;

        for (Searchable item : items) {
            String searchItem = item.getSearchItem();
            int numInclude = 0;
            int index = 0;
            int subIndex = searchItem.indexOf(searchString, index);
            while (subIndex != -1) {
                numInclude++;
                index = subIndex + searchString.length();
                subIndex = searchItem.indexOf(searchString, index);
            }
            if (numInclude > maxInclude) {
                maxInclude = numInclude;
                foundItem = item;
            }
        }

        if (foundItem == null) {
            throw new BestResultNotFound("Не найден подходящий объект по запросу " + searchString);
        }

        return foundItem;
    }

    public void add(Searchable item) {
        items.add(item);
    }
}
