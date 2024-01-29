package christmas;


import christmas.app.Restaurant;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(new OutputView(), new InputView());
        restaurant.enter();
    }
}
