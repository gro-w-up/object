package christmas.domain.reciept;

import christmas.domain.menu.Menu;
import christmas.domain.promotion.Promotion;
import java.util.EnumMap;

public class PromotionResult {
    private final BenefitResult benefitResult;
    private final GiftResult giftResult;

    private PromotionResult(BenefitResult benefitResult, GiftResult giftResult) {
        this.benefitResult = benefitResult;
        this.giftResult = giftResult;
    }

    public static PromotionResult from(BenefitResult benefitResult, GiftResult giftResult) {
        return new PromotionResult(benefitResult, giftResult);
    }

    public double getTotalDiscountedAmount() {
        return benefitResult.getTotalDiscountedAmount();
    }

    public double getTotalBenefitAmount() {
        return benefitResult.getTotalBenefitAmount();
    }

    public EnumMap<Menu, Integer> getGifts() {
        return giftResult.getGifts();
    }

    public EnumMap<Promotion, Double> getBenefitRecords() {
        return benefitResult.getBenefitRecords();
    }
}
