package oort.cloud.movie.domain.discount.policy;

import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
