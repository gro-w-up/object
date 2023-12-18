package org.example.Store.Menu.Impl.main;

import org.example.Money.Won;
import org.example.Store.Menu.MainMenu;

public class TBoneSteak extends MainMenu {
    public TBoneSteak() {
        this.description = "티본스테이크";
    }

    @Override
    public Won cost() {
        return new Won(55_000);
    }

}
