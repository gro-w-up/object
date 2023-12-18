package org.example.Store.Menu;

import org.example.Money.Won;

public abstract class Appetizer implements Menu {
    protected String description = "에피타이저";

    public String getDescription() {
        return description;
    }

    public abstract Won cost();

    @Override
    public String getCategory() {
        return "Appetizer";
    }
}
