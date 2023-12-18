package org.example.Store.Policy;

import java.util.List;
import org.example.Customer.OrderList;
import org.example.Store.Menu.Menu;

public class OrderPolicy {
    // 음료수만 단독으로 주문할 수 없다.

    public static void check(OrderList orderList) {
        if(orderList.getMenuList().stream().allMatch(e -> e.getCategory().equals("Drink"))) {
            throw new IllegalArgumentException("음료수만 단독으로 주문할 수 없습니다.");
        }
    }
}
