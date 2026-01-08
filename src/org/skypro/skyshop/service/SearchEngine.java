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
