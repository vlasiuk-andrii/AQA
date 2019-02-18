package core.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.apache.commons.lang3.time.DateUtils.addDays;

public final class DateUtils {

    private DateUtils() {}

    public final static String DATE_PATTERN = "dd-MM-yyyy";
    public final static String DATE_TIME_PATTERN = "dd-MM-yyyy  HH-mm";
    public final static SimpleDateFormat YEAR_WEEK_FORMATTER = new SimpleDateFormat("yyyyww");
    public final static int DAYS_IN_WEEK = 7;
    public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat( DATE_PATTERN );
    public final static int WEEKS_IN_YEAR = 52;

    public static String getCurrentDate() {
        return DATE_FORMAT.format(System.currentTimeMillis());
    }

    public static Date addWeeks(Date date, int weeks) {
        return addDays(date, weeks * DAYS_IN_WEEK);
    }

    public static String getCurrentDate(String datePattern) {
        SimpleDateFormat customDateFormat = new SimpleDateFormat(datePattern);
        return customDateFormat.format(System.currentTimeMillis());
    }

    public static int getCurrentDay() {
        final LocalDate date = LocalDate.now();
        return date.getDayOfMonth();
    }

    public static int getCurrentWeek() {
        final LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }

    public static String getYearWeekWithOffsetToCurrent(final int offset) {
        int year = getCurrentYear();
        int week = getCurrentWeek() + offset;
        while (week > WEEKS_IN_YEAR) {
            year++;
            week -= WEEKS_IN_YEAR;
        }
        return year + StringUtils.leftPad(String.valueOf(week), 2, "0");
    }

    public static String getCurrentMonth() {
        final LocalDate date = LocalDate.now();
        return date.getMonthValue() < 10 ? "0" + date.getMonthValue() : String.valueOf(date.getMonthValue());
    }

    public static int getCurrentQuarter() {
        final LocalDate date = LocalDate.now();
        return date.get(IsoFields.QUARTER_OF_YEAR);
    }

    public static int getCurrentYear() {
        final LocalDate date = LocalDate.now();
        return date.getYear();
    }

    public static int getDayWithOffsetToCurrent(final int offset) {
        Date date = addDays(new Date(), offset);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getDateWithOffsetToCurrent(final int offset) {
        return DATE_FORMAT.format(getDateWithoutFormatWithOffsetToCurrent(offset));
    }

    public static Date getDateWithoutFormatWithOffsetToCurrent(final int offset) {
        return addDays(new Date(), offset);
    }

    public static String getDateWithOffsetToCurrent(final String datePattern, final int offset) {
        SimpleDateFormat customDateFormat = new SimpleDateFormat(datePattern);
        Date date = addDays(new Date(), offset);
        return customDateFormat.format(date);
    }

    public static String getDateWithOffsetToAnotherDate(final Date anotherDate, final String datePattern, final int offset){
        SimpleDateFormat customDateFormat = new SimpleDateFormat(datePattern);
        Date date = addDays(anotherDate, offset);
        return customDateFormat.format(date);
    }

    public static LocalDate parseDate(final String s){
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public static Date parseStringToDate(final String datePattern, final String s) throws ParseException {
        return new SimpleDateFormat(datePattern).parse(s);
    }

    public static String getMonthName(final String date){
        Month month = parseDate(date).getMonth();
        return month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static int getDay(final String date){
        return parseDate(date).getDayOfMonth();
    }

    public static int getMonth(final String date){
        return parseDate(date).getMonthValue();
    }

    public static int getYear(final String date){
        return parseDate(date).getYear();
    }

    public static long getDaysInCurrentMonth() {
        return Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static boolean isDateGreaterThan(final String actualDate, final String expectedDate) {
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat(DATE_PATTERN).parse(actualDate);
            date2 = new SimpleDateFormat(DATE_PATTERN).parse(expectedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1.after(date2);
    }
}
