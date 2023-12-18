package org.example.Store;

import org.example.Customer.Customer;
import org.example.Store.Policy.OrderPolicy;

public class Store {
    final MenuBoard menuBoard;

    public Store(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
    }

    public String showMenu() {
        return menuBoard.showMenu();
    }

    public void acceptOrderFor(Customer customer) {
        OrderPolicy.check(customer.orderList());
    }

    public MenuBoard passMenu() {
        return menuBoard;
    }
}
