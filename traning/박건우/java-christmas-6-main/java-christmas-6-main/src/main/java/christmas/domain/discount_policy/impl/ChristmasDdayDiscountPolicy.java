package christmas.domain.discount_policy.impl;

import christmas.domain.Money;
import christmas.domain.discount_policy.DiscountPolicy;
import christmas.domain.event.Discount;
import christmas.domain.order.Order;

import java.time.LocalDate;

public class ChristmasDdayDiscountPolicy implements DiscountPolicy {
    private final String DISCOUNT_NAME = "크리스마스 디데이 할인";
    private final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private final LocalDate END_DATE = LocalDate.of(2023, 12, 25) ;
    private final Money BASE_AMOUNT = Money.wons(1000);
    private final Money UNIT_AMOUNT = Money.wons(100);

    @Override
    public Discount apply(Order order) {
        if (!isSatisfied(order)) {
            return Discount.ofNotApplicable(DISCOUNT_NAME);
        }

        int daysAfterStart = START_DATE.until(order.getOrderDate()).getDays();
        Money discountAmount = BASE_AMOUNT.plus(UNIT_AMOUNT.times(daysAfterStart));

        return Discount.of(DISCOUNT_NAME, discountAmount);
    }

    private boolean isSatisfied(Order order) {
        LocalDate orderDate = order.getOrderDate();
        return orderDate.isAfter(START_DATE) && (orderDate.isEqual(END_DATE) || orderDate.isBefore(END_DATE));
    }
}
