package christmas.domain.reciept;

import christmas.domain.menu.Menu;
import christmas.domain.order.MenuCount;
import christmas.domain.order.Order;
import christmas.domain.order.VisitDate;
import christmas.domain.promotion.DecemberEventBadge;
import christmas.domain.promotion.Promotion;
import java.util.EnumMap;

public class Receipt {
    private final Order order;
    private final PromotionResult promotionResult;

    private Receipt(Order order, PromotionResult promotionResult) {
        this.order = order;
        this.promotionResult = promotionResult;
    }

    public static Receipt issue(Order order, PromotionResult promotionResult) {
        return new Receipt(order, promotionResult);
    }

    public double getTotalOrderAmount() {
        return order.getTotalAmount();
    }

    private double getTotalDiscountedAmount() {
        return promotionResult.getTotalDiscountedAmount();
    }

    public double getTotalBenefitAmount() {
        return promotionResult.getTotalBenefitAmount();
    }

    public double getEstimatedPaymentAmount() {
        return getTotalOrderAmount() - getTotalDiscountedAmount();
    }

    public VisitDate getVisitDate() {
        return order.getVisitDate();
    }

    public String getEventBadge() {
        return DecemberEventBadge.getBadgeForTotalBenefitAmount(getTotalBenefitAmount()).getKorean();
    }

    public EnumMap<Menu, MenuCount> getOrders() {
        return order.getOrders();
    }

    public EnumMap<Menu, Integer> getGifts() {
        return promotionResult.getGifts();
    }

    public EnumMap<Promotion, Double> getBenefitRecords() {
        return promotionResult.getBenefitRecords();
    }
}
