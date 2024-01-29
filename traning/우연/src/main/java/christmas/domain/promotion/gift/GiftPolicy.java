package christmas.domain.promotion.gift;

import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionManager;

public interface GiftPolicy {
    void apply(Order order, PromotionManager manager);

    boolean isApplicable(Order order);
}
