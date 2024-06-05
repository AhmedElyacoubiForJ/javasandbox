package java8.importantfunctionalinterface;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

public class FIFunctionDemo {
    public static void main(String[] args) {
        // string to length
        Function<String, Integer> stringToInteger = string -> string.length();
        stringToInteger = String::length;

        Function<PersonDemo, LocalDate> personToBirthday = person -> person.birthday;
        Function<LocalDate, Month> dateToMonth = date -> date.getMonth();

        // first personToBirthday then dateToMonth
        Function<PersonDemo, Month> personToBirthMonth = personToBirthday.andThen(dateToMonth);
        // after dateToMonth, before personToBirthday
        personToBirthMonth = dateToMonth.compose(personToBirthday);

        Function<String, String> toOnYourself = string -> string;
        toOnYourself = Function.identity();

    }
}

class PersonDemo {
    LocalDate birthday;
}
