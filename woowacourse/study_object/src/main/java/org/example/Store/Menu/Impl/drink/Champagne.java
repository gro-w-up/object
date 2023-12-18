package org.example.Store.Menu.Impl.drink;

import org.example.Money.Won;
import org.example.Store.Menu.Drink;

public class Champagne extends Drink {
    public Champagne() {
        this.description = "샴페인";
    }

    @Override
    public Won cost() {
        return new Won(25_000);
    }

}
