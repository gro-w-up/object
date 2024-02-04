package christmas.domain.event;

import christmas.domain.Money;
import christmas.domain.menu.Menu;

public class ServiceResult {
    private final Menu menu;
    private final int quantity;
    private final String description;

    private ServiceResult(Menu menu, int quantity, String description) {
        this.menu = menu;
        this.quantity = quantity;
        this.description = description;
    }

    public static ServiceResult of(Menu menu, int quantity, String description) {
        return new ServiceResult(menu, quantity, description);
    }

    public static ServiceResult ofNotApplicable(Menu menu, int quantity, String description) {
        return new ServiceResult(menu, 0, description);
    }

    public Money calculateBenefit() {
        return menu.getPrice().times(quantity);
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", menu.getName(), quantity);
    }
}
