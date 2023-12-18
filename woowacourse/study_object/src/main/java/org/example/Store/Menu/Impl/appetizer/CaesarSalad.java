package org.example.Store.Menu.Impl.appetizer;

import org.example.Money.Won;
import org.example.Store.Menu.Appetizer;

public class CaesarSalad extends Appetizer {
    public CaesarSalad() {
        this.description = "시저샐러드";
    }

    @Override
    public Won cost() {
        return new Won(8_000);
    }

}
