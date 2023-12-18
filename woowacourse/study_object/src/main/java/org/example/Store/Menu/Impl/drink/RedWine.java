package org.example.Store.Menu.Impl.drink;

import org.example.Money.Won;
import org.example.Store.Menu.Drink;

public class RedWine extends Drink {
    public RedWine() {
        this.description = "레드와인";
    }

    @Override
    public Won cost() {
        return new Won(60_000);
    }

}
