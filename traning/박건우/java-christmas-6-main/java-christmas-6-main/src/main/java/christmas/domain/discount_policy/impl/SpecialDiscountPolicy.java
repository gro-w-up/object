package christmas.domain.discount_policy.impl;

import christmas.domain.Money;
import christmas.domain.discount_policy.DiscountPolicy;
import christmas.domain.event.Discount;
import christmas.domain.order.Order;

import java.util.Set;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private final String DISCOUNT_NAME = "특별 할인";
    public static final Set<Integer> SPECIAL_DISCOUNT_DAYS = Set.of(3, 10, 17, 24, 25, 31);
    public static final Money SPECIAL_DISCOUNT_AMOUNT = Money.wons(1000);

    @Override
    public Discount apply(Order order) {
        int orderDay = order.getOrderDate().getDayOfMonth();

        if (SPECIAL_DISCOUNT_DAYS.contains(orderDay)) {
            return Discount.of(DISCOUNT_NAME, SPECIAL_DISCOUNT_AMOUNT);
        }

        return Discount.ofNotApplicable(DISCOUNT_NAME);
    }
}
