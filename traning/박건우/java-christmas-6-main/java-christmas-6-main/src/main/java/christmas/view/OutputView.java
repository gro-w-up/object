package christmas.view;

import christmas.domain.Money;
import christmas.domain.event.Discount;
import christmas.domain.event.ServiceResult;
import christmas.domain.order.OrderItem;
import christmas.dto.ReceiptDto;

import java.util.List;

public class OutputView {
    private final String NONE = "없음\n";
    private final String MENU_QUANTITY_FORMAT = "%s %d개\n";
    private final String MONEY_FORMAT = "%,d원\n";
    private final String MINUS_MONEY_FORMAT = "-%,d원\n";
    private final String DISCOUNT_BENEFITS_FORMAT = "%s: " + MINUS_MONEY_FORMAT;
    private final String GIFT_BENEFITS_FORMAT = "증정 이벤트: " + MINUS_MONEY_FORMAT;

    public void printEventResult(ReceiptDto receiptDto) {
        printTitleMessage(receiptDto);
        printOrderDetails(receiptDto);
        printPriceBeforeDiscount(receiptDto);
        printServiceMenus(receiptDto);
        printBenefitList(receiptDto);
        printTotalBenefit(receiptDto);
        printPriceAfterDiscount(receiptDto);
        printEventBadge(receiptDto);
    }

    private void printTitleMessage(ReceiptDto receiptDto) {
        System.out.printf("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n",
                receiptDto.orderDate().getMonth().getValue(), receiptDto.orderDate().getDayOfMonth());
    }

    private void printOrderDetails(ReceiptDto receiptDto) {
        System.out.println("<주문 메뉴>");
        List<OrderItem> orderItems = receiptDto.orderItems();

        orderItems.forEach(System.out::println);
        System.out.println();
    }

    private void printPriceBeforeDiscount(ReceiptDto receiptDto) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf(MONEY_FORMAT + "\n", receiptDto.priceBeforeDiscount());
    }

    private void printServiceMenus(ReceiptDto receiptDto) {
        System.out.println("<증정 메뉴>");
        List<ServiceResult> serviceResults = receiptDto.serviceResults();

        if (serviceResults.isEmpty()) {
            System.out.println(NONE);
            return;
        }

        serviceResults.forEach(System.out::println);
        System.out.println();
    }

    private void printBenefitList(ReceiptDto receiptDto) {
        System.out.println("<혜택 내역>");
        if (receiptDto.discountBenefit() == 0 && receiptDto.serviceBenefit() == 0) {
            System.out.println(NONE);
        }

        List<Discount> discounts = receiptDto.discounts();
        discounts.stream()
                .filter(discount -> !discount.getDiscountAmount().equals(Money.ZERO))
                .forEach(discount -> System.out.printf(DISCOUNT_BENEFITS_FORMAT, discount.getDiscountName(), discount.getDiscountAmount().getValue()));

        System.out.printf(GIFT_BENEFITS_FORMAT, receiptDto.serviceBenefit());
        System.out.println();
    }

    private void printTotalBenefit(ReceiptDto receiptDto) {
        System.out.println("<총혜택 금액>");
        int totalBenefit = receiptDto.totalBenefit();

        if (totalBenefit == 0) {
            System.out.printf(MONEY_FORMAT + "\n", totalBenefit);
            return;
        }

        if (totalBenefit > 0) {
            System.out.printf(MINUS_MONEY_FORMAT, totalBenefit);
        }

        System.out.println();
    }

    private void printPriceAfterDiscount(ReceiptDto receiptDto) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf(MONEY_FORMAT, receiptDto.priceAfterDiscount());
        System.out.println();
    }

    private void printEventBadge(ReceiptDto receiptDto) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(receiptDto.badge().getName());
        System.out.println();
    }
}

