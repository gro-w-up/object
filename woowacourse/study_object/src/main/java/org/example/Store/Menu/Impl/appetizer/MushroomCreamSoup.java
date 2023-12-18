package org.example.Store.Menu.Impl.appetizer;

import org.example.Money.Won;
import org.example.Store.Menu.Appetizer;

public class MushroomCreamSoup extends Appetizer {
    public MushroomCreamSoup() {
        this.description = "양송이크림스프";
    }

    @Override
    public Won cost() {
        return new Won(6_000);
    }

}
