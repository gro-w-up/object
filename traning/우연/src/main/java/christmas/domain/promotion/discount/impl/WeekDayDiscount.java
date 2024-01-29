package christmas.domain.promotion.discount.impl;

import static christmas.common.Constant.PROMOTION_END_DAY;
import static christmas.common.Constant.PROMOTION_START_DAY;

import christmas.domain.menu.MenuCategory;
import christmas.domain.order.Order;
import christmas.domain.order.VisitDate;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionManager;
import christmas.domain.promotion.discount.DiscountDecorator;
import christmas.domain.promotion.discount.Discount;

public class WeekDayDiscount extends DiscountDecorator {
    public static final double WEEKDAY_DESSERT_DISCOUNT_AMOUNT = 2023;

    public WeekDayDiscount(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }

    @Override
    public double apply(Order order, double originalPrice, PromotionManager manager) {
        double discountedPrice = decoratedDiscount.apply(order, originalPrice, manager);

        if (isApplicable(order.getVisitDate())) {
            double discountAmount = calculateDiscountAmount(order);
            double resultPrice = discountedPrice - discountAmount;

            manager.addBenefitRecord(Promotion.WEEKDAY_DISCOUNT, discountAmount);

            return resultPrice;
        }
        return discountedPrice;
    }

    private boolean isApplicable(VisitDate visitDate) {
        return visitDate.isDateInPeriod(PROMOTION_START_DAY, PROMOTION_END_DAY) && visitDate.isWeekday();
    }

    private double calculateDiscountAmount(Order order) {
        return WEEKDAY_DESSERT_DISCOUNT_AMOUNT * order.getMenuCount(MenuCategory.DESSERT);
    }
}
