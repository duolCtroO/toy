package oort.cloud.movie.domain.discount.condition;

import oort.cloud.movie.domain.Screening;
import oort.cloud.movie.domain.discount.condition.DiscountCondition;

public class SequenceCondition implements DiscountCondition {
    private final int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
