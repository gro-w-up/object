package christmas.domain.event;

import christmas.domain.Money;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Badge {

    SANTA("산타", benefit -> benefit.isGreaterThanOrEqual(Money.wons(20_000))),
    TREE("트리", benefit -> benefit.isGreaterThanOrEqual(Money.wons(10_000)) && benefit.isLessThan(Money.wons(20_000))),
    STAR("별", benefit -> benefit.isGreaterThanOrEqual(Money.wons(5_000)) && benefit.isLessThan(Money.wons(10_000))),
    NONE("없음", benefit -> benefit.isLessThan(Money.wons(5_000)));

    private final String name;
    private final Predicate<Money> eligible;

    Badge(String name, Predicate<Money> eligible) {
        this.name = name;
        this.eligible = eligible;
    }

    public static Badge findEligibleBadge(Money totalBenefit) {
        return Arrays.stream(values())
                .filter(badge -> badge.eligible.test(totalBenefit))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getName() {
        return name;
    }
}
