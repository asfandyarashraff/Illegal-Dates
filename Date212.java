/**
 * Represents a date in the format MM/dd/yyyy.
 */
public class Date212 implements Comparable<Date212> {
    private int year;
    private int month;
    private int day;

    /**
     * Constructs a Date212 object from a date string in the format MM/dd/yyyy.
     *
     * @param dateString The date string.
     * @throws IllegalDate212Exception If the date string is invalid.
     */
    public Date212(String dateString) throws IllegalDate212Exception {
        // Split the input string based on commas
        String[] dateStrings = dateString.split(",");

        // Process each individual date
        for (String singleDate : dateStrings) {
            // Parse year, month, and day from the input singleDate
            int year = Integer.parseInt(singleDate.substring(0, 4));
            int month = Integer.parseInt(singleDate.substring(4, 6));
            int day = Integer.parseInt(singleDate.substring(6, 8));

            // Check if the parsed values represent a valid date
            if (!isValidDate(year, month, day)) {
                throw new IllegalDate212Exception("Invalid date: " + singleDate);
            }
        }

        // If all dates are valid, set the values for the first date in the list
        this.year = Integer.parseInt(dateStrings[0].substring(0, 4));
        this.month = Integer.parseInt(dateStrings[0].substring(4, 6));
        this.day = Integer.parseInt(dateStrings[0].substring(6, 8));
    }

    /**
     * Checks if the given year, month, and day form a valid date.
     *
     * @param year  The year.
     * @param month The month.
     * @param day   The day.
     * @return True if it's a valid date, false otherwise.
     */
    private boolean isValidDate(int year, int month, int day) {
        return year > 0 && month >= 1 && month <= 12 && day >= 1 && day <= getMaxDaysInMonth(month, year);
    }

    /**
     * Gets the maximum number of days in the given month and year, considering leap years.
     *
     * @param month The month.
     * @param year  The year.
     * @return The maximum number of days in the month.
     */
    private int getMaxDaysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Adjust February for leap years
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        return daysInMonth[month];
    }

    /**
     * Checks whether the given year is a leap year.
     *
     * @param year The year.
     * @return True if it's a leap year, false otherwise.
     */
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Gets the year of the date.
     *
     * @return The year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Converts the date to a string in the format MM/dd/yyyy.
     *
     * @return The formatted date string.
     */
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    /**
     * Compares this date to another date for ordering.
     *
     * @param other The date to compare to.
     * @return A negative integer, zero, or a positive integer as this date is less than,
     * equal to, or greater than the specified date.
     */
    @Override
    public int compareTo(Date212 other) {
        int yearDiff = this.year - other.year;
        if (yearDiff != 0) {
            return yearDiff;
        }

        int monthDiff = this.month - other.month;
        if (monthDiff != 0) {
            return monthDiff;
        }

        return this.day - other.day;
    }
}
