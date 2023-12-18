package org.example.Store.Menu.Impl.main;

import org.example.Money.Won;
import org.example.Store.Menu.MainMenu;

public class SeaFoodPasta extends MainMenu {
    public SeaFoodPasta() {
        this.description = "해물파스타";
    }

    @Override
    public Won cost() {
        return new Won(35_000);
    }

}
