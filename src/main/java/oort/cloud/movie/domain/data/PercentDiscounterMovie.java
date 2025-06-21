package oort.cloud.movie.domain.data;

import oort.cloud.movie.domain.Money;

import java.time.Duration;

public class PercentDiscounterMovie extends MovieData {
    private final double discountPercent;

    public PercentDiscounterMovie(String title, Duration runningTime, Money fee, double discountPercent, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountPercent = discountPercent;
    }

    @Override
    public Money calculateDiscountAmount() {
        return getFee().times(discountPercent);
    }
}
