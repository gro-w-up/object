package christmas.domain.service_policy;

import christmas.domain.event.ServiceResult;
import christmas.domain.order.Order;

public interface ServicePolicy {
    ServiceResult apply(Order order);
}
