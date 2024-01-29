package christmas.domain.promotion.discount;

import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionManager;
import christmas.domain.promotion.discount.impl.BasicDiscount;
import christmas.domain.promotion.discount.impl.ChristmasDdayDiscount;
import christmas.domain.promotion.discount.impl.SpecialDiscount;
import christmas.domain.promotion.discount.impl.WeekDayDiscount;
import christmas.domain.promotion.discount.impl.WeekendDiscount;

import static christmas.common.Constant.DISCOUNT_AMOUNT;

public class DiscountProcessor {
    public void process(Order order, PromotionManager manager) {
        Discount discount = new BasicDiscount();

        if (order.isTotalAmountMoreThan(DISCOUNT_AMOUNT)) {
            discount = new ChristmasDdayDiscount(discount);
            discount = new WeekDayDiscount(discount);
            discount = new WeekendDiscount(discount);
            discount = new SpecialDiscount(discount);
        }

        discount.apply(order, order.getTotalAmount(), manager);
    }
}
