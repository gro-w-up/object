package christmas.domain.event;

import christmas.domain.Money;

public class Discount {
    private String discountName;
    private Money discountAmount;

    private Discount(String discountName, Money discountAmount) {
        this.discountName = discountName;
        this.discountAmount = discountAmount;
    }

    public static Discount of(String discountName, Money discountAmount) {
        return new Discount(discountName, discountAmount);
    }

    public static Discount ofNotApplicable(String discountName) {
        return new Discount(discountName, Money.ZERO);
    }

    public String getDiscountName() {
        return discountName;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

}
