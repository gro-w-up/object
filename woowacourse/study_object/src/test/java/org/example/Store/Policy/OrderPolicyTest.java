package org.example.Store.Policy;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Customer.Customer;
import org.example.Store.MenuBoard;
import org.example.Store.Store;
import org.junit.jupiter.api.Test;

class OrderPolicyTest {

    @Test
    void check() {
        // given
        String order = "제로콜라-1";

        // when
        Customer customer = new Customer();
        customer.requestMenu(new Store(new MenuBoard()));
        customer.writeOrder(order);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            OrderPolicy.check(customer.orderList());
        });
    }

    @Test
    void check2() {
        // given
        String order = "바비큐립-2,제로콜라-1";

        // when
        Customer customer = new Customer();
        customer.requestMenu(new Store(new MenuBoard()));
        customer.writeOrder(order);

        // then
        assertDoesNotThrow(() -> {
            OrderPolicy.check(customer.orderList());
        });
    }
}