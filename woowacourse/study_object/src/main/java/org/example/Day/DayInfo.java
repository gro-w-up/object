package org.example.Day;

public class DayInfo {
    private int currentDay;

    public DayInfo(int currentDay) {
        this.currentDay = currentDay;
    }


    public int getDayOfWeek() {
        // Day 1 = Friday
        // Day 2 = Saturday
        // Day 3 = Sunday
        // Day 4 = Monday
        // Day 5 = Tuesday
        // Day 6 = Wednesday
        // Day 7 = Thursday

        // Monday = 1
        // Tuesday = 2
        // Wednesday = 3
        // Thursday = 4
        // Friday = 5
        // Saturday = 6
        // Sunday = 7
        return (currentDay+4) % 7;
    }
}
