package christmas.domain.event;

import christmas.domain.Money;
import christmas.domain.discount_policy.DiscountPolicy;
import christmas.domain.service_policy.ServicePolicy;
import christmas.domain.order.Order;

import java.util.List;


public class EventPlanner {
    protected final List<DiscountPolicy> discountPolicies;
    protected final List<ServicePolicy> servicePolicies;
    private final Money MINIMUM_EVENT_THRESHOLD = Money.wons(10_000);

    public EventPlanner(List<DiscountPolicy> discountPolicies, List<ServicePolicy> servicePolicies) {
        this.discountPolicies = discountPolicies;
        this.servicePolicies = servicePolicies;
    }

    public EventResult applyEvent(Order order) {
        if (order.getTotalPrice().isLessThan(MINIMUM_EVENT_THRESHOLD)) {
            return EventResult.emptyEventResult();
        }

        EventResult eventResult = new EventResult();

        applyDiscountPolicy(order, eventResult);
        applyServicePolicy(order, eventResult);
        applyEventBadge(eventResult);

        return eventResult;
    }


    private void applyDiscountPolicy(Order order, EventResult eventResult) {
        discountPolicies.forEach(discountPolicy -> eventResult.addDiscount(discountPolicy.apply(order)));
    }

    private void applyServicePolicy(Order order, EventResult eventResult) {
        servicePolicies.forEach(servicePolicy -> eventResult.addServiceResult(servicePolicy.apply(order)));
    }

    private void applyEventBadge(EventResult eventResult) {
        Badge badge = Badge.findEligibleBadge(eventResult.calculateTotalBenefit());
        eventResult.setBadge(badge);
    }
}
