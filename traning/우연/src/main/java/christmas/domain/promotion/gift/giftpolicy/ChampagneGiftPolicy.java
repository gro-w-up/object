package christmas.domain.promotion.gift.giftpolicy;

import static christmas.common.Constant.CHAMPAGNE_GIFT_AMOUNT;

import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.promotion.Promotion;
import christmas.domain.promotion.PromotionManager;
import christmas.domain.promotion.gift.GiftPolicy;

public class ChampagneGiftPolicy implements GiftPolicy {
    private final int CHAMPAGNE_GIFT_COUNT = 1;

    @Override
    public void apply(Order order, PromotionManager manager) {
        if (isApplicable(order)) {
            manager.addGift(Menu.CHAMPAGNE, CHAMPAGNE_GIFT_COUNT);
            manager.addBenefitRecord(Promotion.GIFT_PROMOTION, calculateBenefitAmount());
        }
    }

    @Override
    public boolean isApplicable(Order order) {
        return order.isTotalAmountMoreThan(CHAMPAGNE_GIFT_AMOUNT);
    }

    private double calculateBenefitAmount() {
        return Menu.CHAMPAGNE.getPrice() * CHAMPAGNE_GIFT_COUNT;
    }
}
