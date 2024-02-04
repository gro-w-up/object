package christmas.domain.event;

import christmas.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class EventResult {
    private final List<Discount> discounts = new ArrayList<>();
    private final List<ServiceResult> serviceResults = new ArrayList<>();
    private Badge badge = Badge.NONE;

    public EventResult() {
    }

    public static EventResult emptyEventResult() {
        return new EventResult();
    }

    public Money calculateDiscountBenefit() {
        Money benefit = Money.ZERO;

        for (Discount discount : discounts) {
            benefit = benefit.plus(discount.getDiscountAmount());
        }

        return benefit;
    }

    public Money calculateServiceBenefit() {
        Money benefit = Money.ZERO;

        for (ServiceResult serviceResult : serviceResults) {
            benefit = benefit.plus(serviceResult.calculateBenefit());
        }

        return benefit;
    }

    public Money calculateTotalBenefit() {
        return calculateDiscountBenefit().plus(calculateServiceBenefit());
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public void addServiceResult(ServiceResult serviceResult) {
        serviceResults.add(serviceResult);
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public List<ServiceResult> getServiceResults() {
        return serviceResults;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
