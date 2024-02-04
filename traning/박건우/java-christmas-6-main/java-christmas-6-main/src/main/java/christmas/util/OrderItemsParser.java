package christmas.util;

import christmas.domain.menu.Menu;
import christmas.domain.order.OrderItem;
import christmas.domain.order.OrderItems;
import christmas.exception.InvalidOrderException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OrderItemsParser {
    private static final Pattern pattern = Pattern.compile("([가-힣]+)-([0-9]+)(,([가-힣]+)-([0-9]+))*");

    public OrderItems toOrderItems(String input) {
        input = input.replaceAll("\\s", "");

        if (!pattern.matcher(input).matches()) {
            throw new InvalidOrderException();
        }

        return parse(input);
    }

    private OrderItems parse(String input) {
        List<OrderItem> orderItems = new ArrayList<>();

        String[] menuQuantities = input.split(",");

        for (String menuQuantity : menuQuantities) {
            String[] split = menuQuantity.split("-");

            String menuName = split[0];
            String quantity = split[1];

            orderItems.add(new OrderItem(Menu.getMenuByName(menuName), Integer.parseInt(quantity)));
        }

        return new OrderItems(orderItems);
    }
}
