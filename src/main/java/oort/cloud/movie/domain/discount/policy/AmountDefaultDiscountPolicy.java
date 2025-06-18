package oort.cloud.movie.domain.discount.policy;

import oort.cloud.movie.domain.discount.condition.DiscountCondition;
import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Screening;

public class AmountDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private final Money discountAmount;

    public AmountDefaultDiscountPolicy(Money discountAmount, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}
