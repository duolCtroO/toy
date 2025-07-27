package oort.cloud;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionCheckerTest {
    DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HHmm");
    ExceptionRule[] rules;

    @BeforeEach
    void setUp() {
        ExceptionRule dailyRule = ExceptionRule.create(
                "192.168.127.12",
                ExceptionIpType.DAILY,
                List.of(DayOfWeek.SUNDAY),
                LocalDate.parse("20250727", dateformatter),
                LocalDate.parse("20250728", dateformatter),
                LocalTime.parse("1400", timeformatter),
                LocalTime.parse("1700", timeformatter)
        );

        ExceptionRule monthRule = ExceptionRule.create(
                "192.168.127.13",
                ExceptionIpType.MONTHLY,
                List.of(DayOfWeek.SUNDAY),
                LocalDate.parse("20250727", dateformatter),
                LocalDate.parse("20250728", dateformatter),
                LocalTime.parse("1400", timeformatter),
                LocalTime.parse("1700", timeformatter)
        );

        ExceptionRule weeklyRule = ExceptionRule.create(
                "192.168.127.14",
                ExceptionIpType.WEEKLY,
                List.of(DayOfWeek.SUNDAY),
                LocalDate.parse("20250727", dateformatter),
                LocalDate.parse("20250728", dateformatter),
                LocalTime.parse("1400", timeformatter),
                LocalTime.parse("1700", timeformatter)
        );

        rules = new ExceptionRule[]{dailyRule, monthRule, weeklyRule};
    }


    @Test
    void daily_check_test(){
        Clock successfixedClock = Clock.fixed(
                LocalDateTime.of(2025, 7, 27, 15, 0).atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault()
        );

        Clock failfixedClock = Clock.fixed(
                LocalDateTime.of(2025, 7, 28, 17, 1).atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault()
        );

        ExceptionChecker successChecker = new ExceptionChecker(successfixedClock, rules);
        Assertions.assertTrue(successChecker.check("192.168.127.12"));

        ExceptionChecker failChecker = new ExceptionChecker(failfixedClock, rules);
        Assertions.assertFalse(failChecker.check("192.168.127.11"));
        Assertions.assertFalse(failChecker.check("192.168.127.12"));
    }

    @Test
    void monthly_check_test(){
        Clock fixedClock = Clock.fixed(
                LocalDateTime.of(2025, 7, 27, 15, 0)
                        .atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault()
        );

        ExceptionChecker exceptionChecker = new ExceptionChecker(fixedClock, rules);
        Assertions.assertFalse(exceptionChecker.check("192.168.127.11"));
        Assertions.assertTrue(exceptionChecker.check("192.168.127.13"));
    }

    @Test
    void weekly_check_test(){
        Clock fixedClock = Clock.fixed(
                LocalDateTime.of(2025, 7, 27, 15, 0).atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault()
        );

        ExceptionChecker exceptionChecker = new ExceptionChecker(fixedClock, rules);
        Assertions.assertFalse(exceptionChecker.check("192.168.127.1"));
        Assertions.assertTrue(exceptionChecker.check("192.168.127.14"));
    }
}