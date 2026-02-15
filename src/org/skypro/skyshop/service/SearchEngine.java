package org.skypro.skyshop.service;

import java.util.*;

public class SearchEngine {

    private List<Searchable> items;

    public SearchEngine() {
        this.items = new LinkedList<>();
    }

    public Map<String, Searchable> search(String searchItem) {
        Map<String, Searchable> foundItems = new TreeMap<>();
        for (Searchable item : items) {
            if (item.getSearchItem().contains(searchItem)) {
                foundItems.put(item.getStringRepresentation(), item);
            }
        }
        return foundItems;
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
