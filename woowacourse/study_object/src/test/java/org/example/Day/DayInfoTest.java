package org.example.Day;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayInfoTest {

    @Test
    void getDayOfWeek() {
        // given
        DayInfo dayInfo = new DayInfo(1);
        // then
        assertEquals(5, dayInfo.getDayOfWeek());
    }

    @Test
    void getDayOfWeek2() {
        // given
        DayInfo dayInfo = new DayInfo(25);
        // then
        assertEquals(1, dayInfo.getDayOfWeek());
    }
}