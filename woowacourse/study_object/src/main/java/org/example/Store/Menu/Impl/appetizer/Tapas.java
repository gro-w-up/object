package org.example.Store.Menu.Impl.appetizer;

import org.example.Money.Won;
import org.example.Store.Menu.Appetizer;

public class Tapas extends Appetizer {
    public Tapas() {
        this.description= "타파스";
    }

    @Override
    public Won cost() {
        return new Won(5_500);
    }
}
