package christmas.domain.promotion.gift;

import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionManager;
import java.util.List;

public class GiftProcessor {
    private final List<GiftPolicy> giftPolicies;

    public GiftProcessor(List<GiftPolicy> giftPolicies) {
        this.giftPolicies = giftPolicies;
    }

    public void process(Order order, PromotionManager manager) {
        for (GiftPolicy policy : giftPolicies) {
            policy.apply(order, manager);
        }
    }
}
