package christmas.controller;

import christmas.domain.event.EventPlanner;
import christmas.domain.event.EventResult;
import christmas.domain.order.Order;
import christmas.dto.ReceiptDto;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventPlanner eventPlanner;

    public Controller(InputView inputView, OutputView outputView, EventPlanner eventPlanner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventPlanner = eventPlanner;
    }

    public void launch() {
        Order order = inputView.getOrder();

        EventResult eventResult = eventPlanner.applyEvent(order);

        ReceiptDto receiptDto = ReceiptDto.from(order, eventResult);
        outputView.printEventResult(receiptDto);
    }

}
