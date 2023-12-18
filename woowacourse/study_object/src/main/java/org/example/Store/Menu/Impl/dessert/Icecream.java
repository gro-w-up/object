package org.example.Store.Menu.Impl.dessert;

import org.example.Money.Won;
import org.example.Store.Menu.Dessert;

public class Icecream extends Dessert {
    public Icecream() {
        this.description = "아이스크림";
    }

     @Override
     public Won cost() {
          return new Won(5_000);
     }

}
