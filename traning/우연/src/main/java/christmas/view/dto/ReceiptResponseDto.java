package christmas.view.dto;

import christmas.domain.menu.Menu;
import christmas.domain.order.MenuCount;
import christmas.domain.promotion.Promotion;
import java.util.EnumMap;

public record ReceiptResponseDto(
        int visitMonth,
        int visitDay,
        EnumMap<Menu, MenuCount> orders,
        int totalAmountBeforeDiscount,
        EnumMap<Menu, Integer> gifts,
        EnumMap<Promotion, Double> benefitRecords,
        int totalBenefitAmount,
        int estimatedPaymentAmount,
        String badgeName) {
}
