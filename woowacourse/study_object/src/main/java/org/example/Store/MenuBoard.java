package org.example.Store;

import java.util.List;
import org.example.Store.Menu.Appetizer;
import org.example.Store.Menu.Dessert;
import org.example.Store.Menu.Drink;
import org.example.Store.Menu.Impl.appetizer.CaesarSalad;
import org.example.Store.Menu.Impl.appetizer.MushroomCreamSoup;
import org.example.Store.Menu.Impl.appetizer.Tapas;
import org.example.Store.Menu.Impl.dessert.ChocolateCake;
import org.example.Store.Menu.Impl.dessert.Icecream;
import org.example.Store.Menu.Impl.drink.Champagne;
import org.example.Store.Menu.Impl.drink.RedWine;
import org.example.Store.Menu.Impl.drink.ZeroCoke;
import org.example.Store.Menu.Impl.main.BarbecueRibs;
import org.example.Store.Menu.Impl.main.SeaFoodPasta;
import org.example.Store.Menu.Impl.main.TBoneSteak;
import org.example.Store.Menu.MainMenu;
import org.example.Store.Menu.Menu;

public class MenuBoard {
    /***
     * <애피타이저>
     * 양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
     *
     * <메인>
     * 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
     *
     * <디저트>
     * 초코케이크(15,000), 아이스크림(5,000)
     *
     * <음료>
     * 제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
     */

    final List<Appetizer> appetizerList = List.of(
        new MushroomCreamSoup(),
        new Tapas(),
        new CaesarSalad());

    final List<MainMenu> mainMenuList = List.of(
        new TBoneSteak(),
        new BarbecueRibs(),
        new SeaFoodPasta());
    final List<Dessert> dessertList = List.of(
        new ChocolateCake(),
        new Icecream());
    final List<Drink> drinkList = List.of(
        new ZeroCoke(),
        new RedWine(),
        new Champagne());


    public List<Menu> getMenuList () {
        List<Menu> menuList = new java.util.ArrayList<>();
        menuList.addAll(appetizerList);
        menuList.addAll(mainMenuList);
        menuList.addAll(dessertList);
        menuList.addAll(drinkList);

        return menuList;
    }

    public String showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("<애피타이저>\n");
        for (Appetizer appetizer : appetizerList) {
            sb.append(appetizer.getDescription()).append("(").append(appetizer.cost()).append(")\n");
        }
        sb.append("\n<메인>\n");
        for (MainMenu mainMenu : mainMenuList) {
            sb.append(mainMenu.getDescription()).append("(").append(mainMenu.cost()).append(")\n");
        }
        sb.append("\n<디저트>\n");
        for (Dessert dessert : dessertList) {
            sb.append(dessert.getDescription()).append("(").append(dessert.cost()).append(")\n");
        }
        sb.append("\n<음료>\n");
        for (Drink drink : drinkList) {
            sb.append(drink.getDescription()).append("(").append(drink.cost()).append(")\n");
        }

        return sb.toString();
    }

}
