package org.example.Store.Policy;

import java.util.List;
import org.example.Day.DayInfo;

public class DiscountPolicy {
    public static void discount(DayInfo dayInfo) {
        /***
        * 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
        * 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
        * 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
        ***/
        if (List.of(7, 1, 2, 3, 4).contains(dayInfo.getDayOfWeek())) {
            // 평일 할인
        } else if (List.of(5, 6).contains(dayInfo.getDayOfWeek())) {
            // 주말 할인
        } else {
            // 특별 할인
        }
    }

}
