package oort.cloud.movie.domain.data;

public class SequenceDiscountCondition implements DiscountCondition{
    private final int sequence;

    public SequenceDiscountCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(ScreeningData screeningData) {
        return this.sequence == screeningData.getSequence();
    }
}
