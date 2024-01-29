package christmas.domain.promotion.discount.impl;

import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionManager;
import christmas.domain.promotion.discount.Discount;

public class BasicDiscount implements Discount {
    @Override
    public double apply(Order order, double originalAmount, PromotionManager manager) {
        return order.getTotalAmount();
    }
}
