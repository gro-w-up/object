package christmas.domain.discount_policy.impl;

import christmas.domain.Money;
import christmas.domain.discount_policy.DiscountPolicy;
import christmas.domain.event.Discount;
import christmas.domain.menu.Category;
import christmas.domain.order.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscountPolicy implements DiscountPolicy {
    public static final Money DISCOUNT_UNIT = Money.wons(2023);
    private final String DISCOUNT_NAME = "주말 할인";

    @Override
    public Discount apply(Order order) {
        int mainCourseCount = order.countItemsInCategory(Category.MAIN_COURSE);

        if (!isWeekend(order.getOrderDate()) || mainCourseCount == 0) {
            return Discount.ofNotApplicable(DISCOUNT_NAME);
        }

        return Discount.of(DISCOUNT_NAME, DISCOUNT_UNIT.times(mainCourseCount));
    }

    private boolean isWeekend(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.FRIDAY || localDate.getDayOfWeek() == DayOfWeek.SATURDAY;
    }
}
