package org.example.Customer;

import org.example.Store.Menu.Menu;
import org.example.Store.Store;

public class Customer {
    OrderList orderList;

    public Customer() {

    }
    public void requestMenu(Store store) {
        this.orderList = new OrderList(store.passMenu());
    }

    public void writeOrder(String order) {
        for(String e : order.split(",")) {
            String menuName = e.split("-")[0];
            int menuCount = Integer.parseInt(e.split("-")[1]);
            orderList.addOrder(menuName, menuCount);
        }
    }

    public OrderList orderList() {
        return orderList;
    }

}
