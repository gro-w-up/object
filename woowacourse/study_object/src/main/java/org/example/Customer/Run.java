package org.example.Customer;

import org.example.Store.MenuBoard;
import org.example.Store.Store;

public class Run {
    public static void run() {
        Customer customer = new Customer();
        Store store = new Store(new MenuBoard());

        customer.requestMenu(store);
        customer.writeOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

    }

}
