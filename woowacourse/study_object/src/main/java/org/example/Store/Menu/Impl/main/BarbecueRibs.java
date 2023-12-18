package org.example.Store.Menu.Impl.main;

import org.example.Money.Won;
import org.example.Store.Menu.MainMenu;

public class BarbecueRibs extends MainMenu {
    public BarbecueRibs() {
        this.description = "바비큐립";
    }

    @Override
    public Won cost() {
        return new Won(54_000);
    }

}
