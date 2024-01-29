package christmas.domain.promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Promotion {
    CHRISTMAS_DDAY_DISCOUNT("크리스마스 디데이 할인", PromotionType.DISCOUNT),
    WEEKDAY_DISCOUNT("평일 할인", PromotionType.DISCOUNT),
    WEEKEND_DISCOUNT("주말 할인", PromotionType.DISCOUNT),
    SPECIAL_DAY_DISCOUNT("특별 할인", PromotionType.DISCOUNT),
    GIFT_PROMOTION("증정 이벤트", PromotionType.GIFT);

    private final String description;
    private final PromotionType promotionType;
}
