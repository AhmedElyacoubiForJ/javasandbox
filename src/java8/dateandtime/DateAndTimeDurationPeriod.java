package java8.dateandtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DateAndTimeDurationPeriod {
    public static final int NANO_PER_SECOND = 1_000_000_000; // corresponds 1 second

    public static void main(String[] args) {
        // Duration - time based
        Duration treeSecond = Duration.ofSeconds(3);
        //System.out.println(treeSecond.toSeconds());
        Duration nowTillMidday = Duration.between(LocalTime.now(), LocalTime.of(23, 59, 59));
        //System.out.println(nowTillMidday.toHours());

        LocalTime now = LocalTime.now();
        LocalTime nowPlusThreeSeconds = now.plus(treeSecond);
        //System.out.println(String.format("Now %s in %s seconds", now, nowPlusThreeSeconds));

        int nanosWithoutSeconds = treeSecond.getNano(); // nano is an int not greater than one second
        long seconds = treeSecond.getSeconds();
        //System.out.println(seconds + " seconds");

        Duration foreSeconds = treeSecond.withSeconds(4); // how to change 3 s in 4 s seconds duration
        //System.out.println(foreSeconds.getSeconds());
        //System.out.println(treeSecond.toSeconds());

        Duration treeSecondAndTwoNanos = treeSecond.withNanos(2); // how to change
        System.out.println(String.format(
                "Duration of: %s Seconds & %s nanos",
                treeSecondAndTwoNanos.getSeconds(),
                treeSecondAndTwoNanos.getNano()
                )
        );
        Duration foreSecondAndTwoNanos = treeSecondAndTwoNanos.withSeconds(4); // how to change
        System.out.println(String.format(
                        "Duration of: %s Seconds & %s nanos",
                foreSecondAndTwoNanos.getSeconds(),
                foreSecondAndTwoNanos.getNano()
                )
        );

        long nanosInTotalInTheDuration = nanosWithoutSeconds + (seconds * NANO_PER_SECOND);
        nanosInTotalInTheDuration = treeSecond.getSeconds();
        //System.out.println(nanosInTotalInTheDuration);
        long day = treeSecond.toDays();

        Duration sixSeconds = treeSecond.plus(treeSecond);
        Duration plusOneNanos = treeSecond.plusNanos(1);

        treeSecond = sixSeconds.dividedBy(2);
        Duration eighteenSeconds = sixSeconds.multipliedBy(3);

        // Period - date based
        Period lonPeriod = Period.of(5, 6, 7);
        Period oneYear = Period.ofYears(1);
        Period oneMonth = Period.ofMonths(1);
        Period oneDay = Period.ofDays(1);
        Period oneYearAndOneMonth = oneYear.plus(oneMonth);
        Period oneYearAndOneMonthAndOneDay = oneYearAndOneMonth.plus(oneDay);
        Period twoWeeks = Period.ofWeeks(2);
        Period twoWeeksAndOneDay = twoWeeks.plus(oneDay);
        // like setters
        Period fiveYearsSixMonthSevenDays =
                Period.ofYears(5).withMonths(6).withDays(7);

        LocalDate dateNow = LocalDate.now();
        LocalDate later = dateNow.plus(lonPeriod);

        LocalDate date_2000_1_1 = LocalDate.of(2000, 1, 1);
        // localeDate util localeDate > period
        Period timeTillThe_2000_1_1 = date_2000_1_1.until(dateNow);
        int years = timeTillThe_2000_1_1.getYears(); // age of the customer as example
        int months = timeTillThe_2000_1_1.getMonths(); // between 0 and 11
        long monthsTotal = timeTillThe_2000_1_1.toTotalMonths();
        int days = timeTillThe_2000_1_1.getDays(); // between 0 and 30

        Period noTime = lonPeriod.minus(lonPeriod);
        Period minusOneDay = lonPeriod.minusDays(1);

    }
}
