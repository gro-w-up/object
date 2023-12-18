package org.example.Store.Menu;

import org.example.Money.Won;

public abstract class MainMenu implements Menu {
    protected String description = "메인요리";

    public String getDescription() {
        return description;
    }

    public abstract Won cost();

    @Override
    public String getCategory() {
        return "MainMenu";
    }
}
