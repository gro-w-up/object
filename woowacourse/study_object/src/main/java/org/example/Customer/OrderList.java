package org.example.Customer;

import java.util.ArrayList;
import java.util.List;
import org.example.Store.Menu.Menu;
import org.example.Store.MenuBoard;

public class OrderList {
    MenuBoard menuBoard;
    List<Menu> menuList = new ArrayList<>();

    public OrderList(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void addOrder(String menuName, int menuCount) {
        for(int i=0; i<menuCount; i++) {
            for(Menu e : menuBoard.getMenuList()) {
                if(e.getDescription().equals(menuName)) {
                    menuList.add(e);
                }
            }
        }
    }

    public void deleteOrder(String menuName, int menuCount) {
        for(int i=0; i<menuCount; i++) {
            for(Menu e : menuBoard.getMenuList()) {
                if(e.getDescription().equals(menuName)) {
                    menuList.remove(e);
                }
            }
        }
    }
}
