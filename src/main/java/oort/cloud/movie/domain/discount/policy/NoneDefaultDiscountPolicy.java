package oort.cloud.movie.domain.discount.policy;

import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Screening;

public class NoneDefaultDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
