package christmas.domain.promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public enum DecemberEventBadge {
    NONE("없음", 0, amount -> amount < 5000),
    STAR("별", 5000, amount -> amount >= 5000 && amount < 10000),
    TREE("트리", 10000, amount -> amount >= 10000 && amount < 20000),
    SANTA("산타", 20000, amount -> amount >= 20000);

    private final String korean;
    private final double threshold;
    private final Predicate<Double> matcher;

    public static DecemberEventBadge getBadgeForTotalBenefitAmount(double amount) {
        return Arrays.stream(DecemberEventBadge.values())
                .filter(badge -> badge.matcher.test(amount))
                .findFirst()
                .orElse(NONE);
    }
}
