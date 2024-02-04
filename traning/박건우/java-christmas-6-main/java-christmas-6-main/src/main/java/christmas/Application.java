package christmas;

import christmas.controller.Controller;
import christmas.domain.discount_policy.DiscountPolicy;
import christmas.domain.discount_policy.impl.ChristmasDdayDiscountPolicy;
import christmas.domain.discount_policy.impl.SpecialDiscountPolicy;
import christmas.domain.discount_policy.impl.WeekdayDiscountPolicy;
import christmas.domain.discount_policy.impl.WeekendDiscountPolicy;
import christmas.domain.event.EventPlanner;
import christmas.domain.service_policy.ServicePolicy;
import christmas.domain.service_policy.impl.ChampaignServicePolicy;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<DiscountPolicy> discountPolicies = List.of(
                new ChristmasDdayDiscountPolicy(),
                new SpecialDiscountPolicy(),
                new WeekdayDiscountPolicy(),
                new WeekendDiscountPolicy()
        );

        List<ServicePolicy> servicePolicies = List.of(new ChampaignServicePolicy());
        EventPlanner eventPlanner = new EventPlanner(discountPolicies, servicePolicies);

        Controller controller = new Controller(new InputView(), new OutputView(), eventPlanner);
        controller.launch();
    }
}
