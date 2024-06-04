package java8.dateandtime;

import java.time.Duration;
import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime midday = LocalTime.of(12, 0, 0, 0);
        //System.out.println(midday);
        LocalTime now = LocalTime.now();
        //System.out.println(now);
        LocalTime twoAfterFour = LocalTime.parse("04:02:00.00000000"); // nanosecond
        //System.out.println(twoAfterFour);
        //System.out.println(twoAfterFour.getNano());

        int nowHour = now.getHour();
        // LocalTime is immutable
        LocalTime nowOnEighth = now.withHour(8);
        //System.out.println(String.format("Now %s around 8 hour %s", now, nowOnEighth));

        boolean isAfterMidday = now.isAfter(midday);
        boolean isBeforeMidday = now.isBefore(midday);
        //System.out.println(isAfterMidday);
        //System.out.println(isBeforeMidday);

        LocalTime nowBeforeFiveMinutes = now.minus(Duration.ofMinutes(5));
        //System.out.println(String.format("Now %s before 5 minutes %s", now, nowBeforeFiveMinutes));

        LocalTime nowInFiveMinutes = now.plusMinutes(5);
        System.out.println(String.format("Now %s in 5 minutes %s", now, nowInFiveMinutes));


    }
}
