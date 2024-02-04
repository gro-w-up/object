package christmas.domain.menu;


import christmas.domain.Money;
import christmas.exception.InvalidOrderException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", Money.wons(6_000), Category.APPETIZER),
    TAPAS("타파스", Money.wons(5_500), Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", Money.wons(8_000), Category.APPETIZER),
    T_BONE_STEAK("티본스테이크", Money.wons(55_000), Category.MAIN_COURSE),
    BBQ_RIB("바비큐립", Money.wons(54_000), Category.MAIN_COURSE),
    SEAFOOD_PASTA("해산물파스타", Money.wons(35_000), Category.MAIN_COURSE),
    CHRISTMAS_PASTA("크리스마스파스타", Money.wons(25_000), Category.MAIN_COURSE),
    CHOCOLATE_CAKE("초코케이크", Money.wons(15_000), Category.DESSERT),
    ICE_CREAM("아이스크림", Money.wons(5_000), Category.DESSERT),
    ZERO_COLA("제로콜라", Money.wons(3_000), Category.BEVERAGE),
    RED_WINE("레드와인", Money.wons(60_000), Category.BEVERAGE),
    CHAMPAGNE("샴페인", Money.wons(25_000), Category.BEVERAGE);

    private final String name;
    private final Money price;
    private final Category category;
    private static final Map<String, Menu> menuNameMap = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(menu -> menuNameMap.put(menu.name, menu));
    }

    Menu(String name, Money price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Money getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public static Menu getMenuByName(String name) {
        if (!menuNameMap.containsKey(name)) {
            throw new InvalidOrderException();
        }

        return menuNameMap.get(name);
    }

    public String getName() {
        return name;
    }
}
