package org.example.Store.Menu.Impl.dessert;

import org.example.Money.Won;
import org.example.Store.Menu.Dessert;

public class ChocolateCake extends Dessert {
   public ChocolateCake() {
      this.description = "초코케이크";
   }

    @Override
    public Won cost() {
        return new Won(15_000);
    }

}
