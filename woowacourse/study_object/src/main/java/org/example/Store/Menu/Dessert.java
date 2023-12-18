package org.example.Store.Menu;

import org.example.Money.Won;

public abstract class Dessert implements Menu {
    protected String description = "디저트";

    public String getDescription() {
        return description;
    }

    public abstract Won cost();

    @Override
    public String getCategory() {
        return "Dessert";
    }
}
