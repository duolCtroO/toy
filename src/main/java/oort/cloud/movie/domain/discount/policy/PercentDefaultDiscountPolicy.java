package oort.cloud.movie.domain.discount.policy;

import oort.cloud.movie.domain.discount.condition.DiscountCondition;
import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Screening;

public class PercentDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private final double percent;

    public PercentDefaultDiscountPolicy(double percent, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
