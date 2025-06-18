package oort.cloud.movie.domain.discount.policy;

import oort.cloud.movie.domain.discount.condition.DiscountCondition;
import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Screening;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private final List<DiscountCondition> discountConditions;

    protected DefaultDiscountPolicy(DiscountCondition... discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening){
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening)) ? getDiscountAmount(screening) : Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Screening screening);
}
