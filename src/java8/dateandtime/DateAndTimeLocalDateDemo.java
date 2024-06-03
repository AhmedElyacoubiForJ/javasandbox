package java8.dateandtime;

import java.time.LocalDate;

public class DateAndTimeLocalDateDemo {
    public static void main(String[] args) {
        /* Problem before java 8*/
        /*  Date java8ReleaseAsDate = new Date(2014,3,18);
        System.out.println(java8ReleaseAsDate); // 3914
        int diff = 3914 - 2014;
        System.out.println(diff);
        java8ReleaseAsDate = new Date(2014-diff,3-1,18);
        System.out.println(java8ReleaseAsDate);
        */
        /*
        Calendar java8ReleaseAlsCalendar = new GregorianCalendar(2014, 3, 18);
        System.out.println(java8ReleaseAlsCalendar.getTime());
        java8ReleaseAlsCalendar = new GregorianCalendar(2014, 3-1, 18);
        System.out.println(java8ReleaseAlsCalendar.getTime());
        */

//        LocalDate java8ReleaseAsLocalDate = LocalDate.of(2014, 3, 18); // ISO FORMAT
//        System.out.println(java8ReleaseAsLocalDate);
//
//        java8ReleaseAsLocalDate = LocalDate.of(2014, Month.MARCH, 18);
//        System.out.println(java8ReleaseAsLocalDate);
//
//        System.out.println(Month.of(3));
//
//        LocalDate today = LocalDate.now();
//        System.out.println(today);

//        String dateStr = "2000-01-01"; // ISO FORMAT
//        LocalDate newYear2000 = LocalDate.parse(dateStr);
//        System.out.println(newYear2000);
//
//        newYear2000 = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
//        System.out.println(newYear2000);
//        newYear2000 = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE.withLocale(Locale.FRANCE));
//        System.out.println(newYear2000);
//        newYear2000 = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE.withLocale(Locale.GERMANY));
//
//        dateStr = "01-01-2000";
//        newYear2000 = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        System.out.println(newYear2000);
//
//        // not ISO FORMAT > Exception
//        // newYear2000 = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
//        // System.out.println(newYear2000);

        LocalDate now = LocalDate.now();
        System.out.println(now);
//        int dayOfMonth = now.getDayOfMonth();
//        int dayOfWeek = now.getDayOfWeek().getValue();
//        int month = now.getMonthValue();
//        int year = now.getYear();
//        System.out.println(dayOfMonth);
//        System.out.println(dayOfWeek);
//        System.out.println(month);

        // immutable
//        now.plusDays(1);
//        now.plusMonths(1);
//        now.plusYears(1);
//        System.out.println(now);

/*        // immutable
        LocalDate nowPlusOneDay = now.plusDays(1);
        LocalDate nowPlusOneDayPlusOneMonth = nowPlusOneDay.plusMonths(1);
        LocalDate nowPlusOneDayPlusOneMonthPlusOneYear = nowPlusOneDayPlusOneMonth.plusYears(1);
        System.out.println(nowPlusOneDayPlusOneMonthPlusOneYear);

        // immutable
        now = now.plusDays(1);
        now = now.plusMonths(1);
        now = now.plusYears(1);
        System.out.println(now);

        now = now.minusDays(1);
        now = now.minusMonths(1);
        now = now.minusYears(1);
        System.out.println(now);*/

//        LocalDate localDate = LocalDate.of(2000, 5, 5);
//
//        System.out.println( now.isBefore(localDate) );
//        System.out.println( now.isAfter(localDate) );
//        System.out.println(localDate.isBefore(now));
//        System.out.println(localDate.isAfter(now));


        //
       // System.out.println(now.isEqual(LocalDate.now()));


        Person person = new Person();
        person.birthday = LocalDate.of(1967, 03, 15);
        System.out.println(person.getAge());


    }
}

class Person {
    LocalDate birthday;

    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = birthday.until(now).getYears();
        return age;
    }
}
