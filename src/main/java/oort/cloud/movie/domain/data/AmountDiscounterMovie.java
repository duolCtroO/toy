package oort.cloud.movie.domain.data;

import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Movie;

import java.time.Duration;

public class AmountDiscounterMovie extends MovieData{
    private Money discountAmount;

    public AmountDiscounterMovie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money calculateDiscountAmount() {
        return discountAmount;
    }
}
