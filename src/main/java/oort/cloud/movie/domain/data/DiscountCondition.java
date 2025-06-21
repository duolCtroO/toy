package oort.cloud.movie.domain.data;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DiscountCondition {
    boolean isSatisfiedBy(ScreeningData screeningData);
}
