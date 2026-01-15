package org.skypro.skyshop.service;

public class SearchEngine {

    private Searchable[] items;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
    }

    public Searchable[] search(String searchItem) {
        int count = 0;
        Searchable[] foundItems = new Searchable[5];

        for (Searchable item : items) {
            if (item != null) {
                if (item.getSearchItem().contains(searchItem)) {
                    foundItems[count] = item;
                    count++;
                }
            }
            if (count == 5) {
                break;
            }
        }
        return foundItems;
    }

    public Searchable searchBestResult(String searchString) throws BestResultNotFound {

        Searchable foundItem = null;
        int maxInclude = 0;

        for (Searchable item : items) {
            if (item != null) {
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
        }

        if (foundItem == null) {
            throw new BestResultNotFound("Не найден подходящий объект по запросу " + searchString);
        }

        return foundItem;
    }

    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
        System.out.println("Невозможно добавить объект");
    }
}
