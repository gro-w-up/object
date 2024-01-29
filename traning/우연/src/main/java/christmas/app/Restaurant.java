package christmas.app;

import christmas.domain.order.Order;
import christmas.domain.order.VisitDate;
import christmas.domain.promotion.PromotionManager;
import christmas.domain.promotion.gift.giftpolicy.ChampagneGiftPolicy;
import christmas.domain.reciept.PromotionResult;
import christmas.domain.reciept.Receipt;
import christmas.util.mapper.DtoModelMapper;
import christmas.util.validator.InputOrderValidator;
import christmas.util.validator.InputVisitDayValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.dto.OrderRequestDto;
import christmas.view.dto.VisitDayRequestDto;

import java.util.List;

public class Restaurant {

    private final OutputView outputView;
    private final InputView inputView;

    public Restaurant(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void enter() {
        outputView.printWelcomeMessage();

        VisitDate visitDate = getValidVisitDate();
        Order order = getValidOrder(visitDate);

        Receipt receipt = Receipt.issue(order, calculatePromotionResult(order));
        outputView.printPromotionBenefits(DtoModelMapper.ReceiptToDto(receipt));
    }

    private VisitDate getValidVisitDate() {
        while (true) {
            try {
                VisitDayRequestDto requestDto = inputView.readVisitDay();
                InputVisitDayValidator.validateVisitDay(requestDto.day());

                return DtoModelMapper.dtoToVisitDate(requestDto);
            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
                outputView.printRequestReenterVisitDay();
            }
        }
    }

    private Order getValidOrder(VisitDate visitDate) {
        while (true) {
            try {
                OrderRequestDto requestDto = inputView.readOrder();
                InputOrderValidator.validateOrder(requestDto.order());

                return DtoModelMapper.dtoToOrder(visitDate, requestDto);
            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
                outputView.printRequestReenterOrder();
            }
        }
    }

    private PromotionResult calculatePromotionResult(Order order) {
        PromotionManager promotionManager = new PromotionManager(
                List.of(new ChampagneGiftPolicy())
        );
        return promotionManager.getResult(order);
    }
}
