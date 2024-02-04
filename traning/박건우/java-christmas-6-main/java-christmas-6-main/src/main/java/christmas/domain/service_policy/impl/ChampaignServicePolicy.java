package christmas.domain.service_policy.impl;

import christmas.domain.Money;
import christmas.domain.event.ServiceResult;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.service_policy.ServicePolicy;

public class ChampaignServicePolicy implements ServicePolicy {
    private static final Money CHAMPAGNE_SERVICE_THRESHOLD = Money.wons(120_000);

    @Override
    public ServiceResult apply(Order order) {
        if (order.getTotalPrice().isGreaterThanOrEqual(CHAMPAGNE_SERVICE_THRESHOLD)) {
            return ServiceResult.of(Menu.CHAMPAGNE, 1, "샴페인 서비스 정책");
        }

        return ServiceResult.of(Menu.CHAMPAGNE, 0, "샴페인 서비스 정책");
    }

}
