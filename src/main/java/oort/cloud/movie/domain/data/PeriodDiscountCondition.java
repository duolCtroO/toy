package oort.cloud.movie.domain.data;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodDiscountCondition implements DiscountCondition{
    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public PeriodDiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(ScreeningData screeningData) {
        return this.dayOfWeek.equals(screeningData.getWhenScreened().getDayOfWeek())
                && this.startTime.isAfter(screeningData.getWhenScreened().toLocalTime())
                && this.endTime.isBefore(screeningData.getWhenScreened().toLocalTime());
    }
}
