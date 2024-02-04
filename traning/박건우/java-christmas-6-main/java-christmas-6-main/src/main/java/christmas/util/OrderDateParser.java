package christmas.util;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;

import java.time.LocalDate;
import java.time.YearMonth;

public class OrderDateParser {
    private final int year;
    private final int month;

    public OrderDateParser(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public LocalDate toLocalDate(String input) {
        validate(input);

        return LocalDate.of(year, month, Integer.parseInt(input));
    }

    private void validate(String input) throws InvalidDateException {
        int dayOfMonth = validateInteger(input);

        if (!YearMonth.of(year, month).isValidDay(dayOfMonth)) {
            throw new InvalidDateException();
        }
    }
    private int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException();
        }
    }
}
