package christmas.domain.discount_policy;

import christmas.domain.event.Discount;
import christmas.domain.order.Order;

public interface DiscountPolicy {
    Discount apply(Order order);
}
