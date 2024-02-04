package christmas.domain.order;

import christmas.domain.Money;
import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

public class OrderItem {
    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return menu.getPrice().times(quantity);
    }

    public Category getCategory() {
        return menu.getCategory();
    }

    @Override
    public String toString() {
        return String.format("%s %d개", menu.getName(), quantity);
    }
}
