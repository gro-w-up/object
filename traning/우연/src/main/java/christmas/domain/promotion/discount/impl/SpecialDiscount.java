package christmas.domain.promotion.discount.impl;

import static christmas.common.Constant.PROMOTION_END_DAY;
import static christmas.common.Constant.PROMOTION_START_DAY;

import christmas.domain.order.Order;
import christmas.domain.order.VisitDate;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionManager;
import christmas.domain.promotion.discount.DiscountDecorator;
import christmas.domain.promotion.discount.Discount;

public class SpecialDiscount extends DiscountDecorator {
    public static final double SPECIAL_DISCOUNT_AMOUNT = 1000;

    public SpecialDiscount(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }

    @Override
    public double apply(Order order, double originalPrice, PromotionManager manager) {
        double discountedPrice = decoratedDiscount.apply(order, originalPrice, manager);

        if (isApplicable(order.getVisitDate())) {
            double discountAmount = SPECIAL_DISCOUNT_AMOUNT;
            double resultPrice = discountedPrice - discountAmount;

            manager.addBenefitRecord(Promotion.SPECIAL_DAY_DISCOUNT, discountAmount);

            return resultPrice;
        }
        return discountedPrice;
    }

    private boolean isApplicable(VisitDate visitDate) {
        return visitDate.isDateInPeriod(PROMOTION_START_DAY, PROMOTION_END_DAY) && visitDate.isSpecialDay();
    }
}
