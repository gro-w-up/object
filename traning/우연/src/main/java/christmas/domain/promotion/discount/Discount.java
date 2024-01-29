package christmas.domain.promotion.discount;

import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionManager;

public interface Discount {
    double apply(Order order, double originalAmount, PromotionManager manager);
}
