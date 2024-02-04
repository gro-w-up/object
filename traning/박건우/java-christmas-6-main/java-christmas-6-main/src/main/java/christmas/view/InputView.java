package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItems;
import christmas.util.OrderDateParser;
import christmas.util.OrderItemsParser;

import java.time.LocalDate;
import java.util.function.Function;

public class InputView {
    private final OrderDateParser orderDateParser = new OrderDateParser(2023, 12);
    private final OrderItemsParser orderItemsParser = new OrderItemsParser();

    public Order getOrder() {
        LocalDate visitDate = requestOrderDate();
        OrderItems orderItems = requestOrderItems();

        return Order.of(visitDate, orderItems);
    }

    private LocalDate requestOrderDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        return readConsoleInput(orderDateParser::toLocalDate);
    }

    private OrderItems requestOrderItems() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        return readConsoleInput(orderItemsParser::toOrderItems);
    }

    public <T> T readConsoleInput(Function<String, T> inputParser) {
        while (true) {
            try {
                String input = Console.readLine();
                return inputParser.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
