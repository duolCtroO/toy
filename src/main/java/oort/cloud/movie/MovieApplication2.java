package oort.cloud.movie;

import oort.cloud.movie.domain.*;
import oort.cloud.movie.domain.discount.policy.DiscountPolicy;
import oort.cloud.movie.domain.discount.policy.NoneDefaultDiscountPolicy;
import oort.cloud.movie.domain.discount.condition.DiscountCondition;
import oort.cloud.movie.domain.discount.condition.PeriodCondition;

import java.math.BigDecimal;
import java.time.*;

public class MovieApplication2 {
    public static void main(String[] args) {
        DiscountCondition periodCondition = new PeriodCondition(
                DayOfWeek.THURSDAY,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0));
        DiscountPolicy noneDiscountPolicy = new NoneDefaultDiscountPolicy();
        Movie tazza = new Movie(
                "타짜",
                Duration.ofMinutes(200),
                new Money(BigDecimal.valueOf(12000)),
                noneDiscountPolicy);
        Screening screening = new Screening(tazza, 1, LocalDateTime.now());


        noneDiscountPolicy.calculateDiscountAmount(screening);
    }
}
