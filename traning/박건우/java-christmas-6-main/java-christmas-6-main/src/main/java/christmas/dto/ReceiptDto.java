package christmas.dto;

import christmas.domain.event.Badge;
import christmas.domain.event.Discount;
import christmas.domain.event.EventResult;
import christmas.domain.event.ServiceResult;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;

import java.time.LocalDate;
import java.util.List;

public record ReceiptDto(
        LocalDate orderDate,
        List<OrderItem> orderItems,
        int priceBeforeDiscount,
        List<ServiceResult> serviceResults,
        List<Discount> discounts,
        int discountBenefit,
        int serviceBenefit,
        int totalBenefit,
        int priceAfterDiscount,
        Badge badge
) {
    public static ReceiptDto from(Order order, EventResult eventResult) {
        return new ReceiptDto(
                order.getOrderDate(),
                order.getOrderItems(),
                order.getTotalPrice().getValue(),
                eventResult.getServiceResults(),
                eventResult.getDiscounts(),
                eventResult.calculateDiscountBenefit().getValue(),
                eventResult.calculateServiceBenefit().getValue(),
                eventResult.calculateTotalBenefit().getValue(),
                order.getTotalPrice().minus(eventResult.calculateDiscountBenefit()).getValue(),
                eventResult.getBadge());
    }
}

