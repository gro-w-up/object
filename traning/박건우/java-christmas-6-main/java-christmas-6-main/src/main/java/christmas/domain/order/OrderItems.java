package christmas.domain.order;

import christmas.domain.Money;
import christmas.domain.menu.Category;
import christmas.exception.InvalidOrderException;

import java.util.List;

public class OrderItems {
    private final List<OrderItem> orderItems;
    private static final int MAX_MENU_QUANTITY = 20;

    public OrderItems(List<OrderItem> orderItems) {
        validate(orderItems);
        this.orderItems = orderItems;
    }

    private void validate(List<OrderItem> orderItems) throws InvalidOrderException {
        if (hasOnlyBeverage(orderItems) || exceedMaxMenuQuantity(orderItems)) {
            throw new InvalidOrderException();
        }
    }

    private boolean exceedMaxMenuQuantity(List<OrderItem> orderItems) {
        int totalQuantity = orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();

        return totalQuantity > MAX_MENU_QUANTITY;
    }

    private boolean hasOnlyBeverage(List<OrderItem> orderItems) {
        return orderItems.stream()
                .allMatch(orderItem -> orderItem.getCategory() == Category.BEVERAGE);
    }

    public Money getTotalPrice() {
        return orderItems.stream()
                .map(OrderItem::getPrice)
                .reduce(Money.ZERO, Money::plus);
    }

    public int getCountItemsInCategory(Category category) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getCategory() == category)
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
