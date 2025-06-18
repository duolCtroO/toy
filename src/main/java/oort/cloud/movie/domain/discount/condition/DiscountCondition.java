package oort.cloud.movie.domain.discount.condition;

import oort.cloud.movie.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
