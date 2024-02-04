package christmas.domain.order;

import christmas.domain.Money;
import christmas.domain.menu.Category;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final LocalDate orderDate;
    private final OrderItems orderItems;

    private Order(LocalDate orderDate, OrderItems orderItems) {
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

    public static Order of(LocalDate visitDate, OrderItems orderItems) {
        return new Order(visitDate, orderItems);
    }

    public Money getTotalPrice() {
        return orderItems.getTotalPrice();
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems.getOrderItems();
    }

    public int countItemsInCategory(Category category) {
        return orderItems.getCountItemsInCategory(category);
    }
}
