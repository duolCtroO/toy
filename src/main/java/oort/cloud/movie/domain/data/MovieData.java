package oort.cloud.movie.domain.data;
import oort.cloud.movie.domain.Money;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public abstract class MovieData {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public MovieData(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(ScreeningData screeningData) {
        if(isDiscountable(screeningData)){
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    public abstract Money calculateDiscountAmount();

    private boolean isDiscountable(ScreeningData screeningData){
        return discountConditions.stream()
                .anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screeningData));
    }

    protected Money getFee() {
        return fee;
    }
}
