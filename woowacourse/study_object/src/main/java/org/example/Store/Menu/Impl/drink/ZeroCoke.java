package org.example.Store.Menu.Impl.drink;

import org.example.Money.Won;
import org.example.Store.Menu.Drink;

public class ZeroCoke extends Drink {
    public ZeroCoke() {
        this.description = "제로콜라";
    }

    @Override
    public Won cost() {
        return new Won(3_000);
    }

}
