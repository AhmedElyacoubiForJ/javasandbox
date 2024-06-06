package java8.dateandtime;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

public class DateAndTimeMonthDayDemo {
    public static void main(String[] args) {
        System.out.println(LocalDate.of(2014,1,1));

        MonthDay nowMonthDay = MonthDay.now();
        System.out.println(nowMonthDay); // --mm-dd

        // use case for events that are not dependent on year
        // birthday is also best use for MonthDay
        MonthDay dayOfGermanUnity = MonthDay.of(Month.OCTOBER, 3);
        LocalDate dayOfGermanyUnity1990 = dayOfGermanUnity.atYear(1990);

        // Christmas is an MonthDay
        MonthDay christmas = MonthDay.of(Month.DECEMBER, 24);

        // commandment of jesus is also an MonthDay
        MonthDay commandmentOfJesus = MonthDay.of(Month.JANUARY, 6);

        //
        int birthsYear = 1967;
        MonthDay birthsMonthDay = MonthDay.of(Month.MARCH, 15);
        LocalDate birthday = birthsMonthDay.atYear(birthsYear);
        System.out.println(birthday);

        //
        Month october = dayOfGermanUnity.getMonth();
        int tenBecauseOfOctober = dayOfGermanUnity.getMonthValue();
        int treeBecauseOfThirdsOfMonth = dayOfGermanUnity.getDayOfMonth();

        // within year will be compared
        boolean isDayOfGermanUnityAfterNow = dayOfGermanUnity.isAfter(nowMonthDay);
        System.out.println(isDayOfGermanUnityAfterNow);
        System.out.println(nowMonthDay.isAfter(dayOfGermanUnity));

        // getting the MonthDay from the LocalDate
        LocalDate nowLocalDate = LocalDate.now();
        nowMonthDay = MonthDay.from(nowLocalDate);
        System.out.println(nowMonthDay);

    }
}
