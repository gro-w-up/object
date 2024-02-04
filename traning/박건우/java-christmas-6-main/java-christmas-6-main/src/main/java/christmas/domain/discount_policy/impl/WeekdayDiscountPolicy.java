package christmas.domain.discount_policy.impl;

import christmas.domain.Money;
import christmas.domain.discount_policy.DiscountPolicy;
import christmas.domain.event.Discount;
import christmas.domain.menu.Category;
import christmas.domain.order.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountPolicy implements DiscountPolicy {

    private final String DISCOUNT_NAME = "평일 할인";
    private static final Money DISCOUNT_UNIT = Money.wons(2023);

    @Override
    public Discount apply(Order order) {
        LocalDate orderDate = order.getOrderDate();
        int dessertCount = order.countItemsInCategory(Category.DESSERT);

        if (!isWeekday(orderDate) || dessertCount == 0 ) {
            return Discount.ofNotApplicable(DISCOUNT_NAME);
        }

        return Discount.of(DISCOUNT_NAME, DISCOUNT_UNIT.times(dessertCount));
    }

    private boolean isWeekday(LocalDate localDate) {
        return !(localDate.getDayOfWeek() == DayOfWeek.FRIDAY || localDate.getDayOfWeek() == DayOfWeek.SATURDAY);
    }
}
