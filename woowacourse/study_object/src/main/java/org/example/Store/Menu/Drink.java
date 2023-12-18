package org.example.Store.Menu;

import org.example.Money.Won;

public abstract class Drink implements Menu {
    protected String description = "드링크";

    public String getDescription() {
        return description;
    }

    public abstract Won cost();

    @Override
    public String getCategory() {
        return "Drink";
    }
}
