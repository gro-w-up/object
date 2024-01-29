package christmas.domain.reciept;

import christmas.domain.menu.Menu;
import java.util.EnumMap;

public class GiftResult {
    private final EnumMap<Menu, Integer> Gifts;

    private GiftResult(EnumMap<Menu, Integer> Gifts) {
        this.Gifts = Gifts;
    }

    public static GiftResult from(EnumMap<Menu, Integer> Gifts) {
        return new GiftResult(Gifts);
    }

    public EnumMap<Menu, Integer> getGifts() {
        return Gifts;
    }
}
