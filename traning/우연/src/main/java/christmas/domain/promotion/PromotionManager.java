package christmas.domain.promotion;

import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.promotion.discount.DiscountProcessor;
import christmas.domain.promotion.gift.GiftPolicy;
import christmas.domain.promotion.gift.GiftProcessor;
import christmas.domain.reciept.BenefitResult;
import christmas.domain.reciept.GiftResult;
import christmas.domain.reciept.PromotionResult;

import java.util.EnumMap;
import java.util.List;

public class PromotionManager {
    private EnumMap<Promotion, Double> benefitRecords;
    private EnumMap<Menu, Integer> gifts;
    private final DiscountProcessor discountProcessor;
    private final GiftProcessor giftProcessor;

    public PromotionManager(List<GiftPolicy> giftPolicies) {
        this.benefitRecords = new EnumMap<>(Promotion.class);
        this.gifts = new EnumMap<>(Menu.class);
        this.discountProcessor = new DiscountProcessor();
        this.giftProcessor = new GiftProcessor(giftPolicies);
    }

    public void addGift(Menu gift, int count) {
        this.gifts.merge(gift, count, Integer::sum);
    }

    public void addBenefitRecord(Promotion type, double amount) {
        benefitRecords.merge(type, amount, Double::sum);
    }

    public PromotionResult getResult(Order order) {
        discountProcessor.process(order, this);
        giftProcessor.process(order, this);

        return PromotionResult.from(BenefitResult.from(benefitRecords), GiftResult.from(gifts));
    }
}
