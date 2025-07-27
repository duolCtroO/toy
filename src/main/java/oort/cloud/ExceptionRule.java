package oort.cloud;

import java.time.*;
import java.util.List;
import java.util.Objects;

public class ExceptionRule {
    //예외 대상 IP
    private String ip;

    //예외 타입 -> 매일, 매월, 매주
    private ExceptionIpType exceptionIpType;

    //예외 적용 요일
    private List<DayOfWeek> dayOfWeeks;

    //예외 적용 월
    private List<Month> months;

    //예외를 적용할 기간
    private LocalDate startDay;
    private LocalDate endDay;

    //예외 적용 시간
    private LocalTime startTime;
    private LocalTime endTime;

    private ExceptionRule(){}

    public static ExceptionRule create(String ip, ExceptionIpType exceptionIpType, List<DayOfWeek> dayOfWeeks, LocalDate startDay, LocalDate endDay, LocalTime startTime, LocalTime endTime){
        ExceptionRule exceptionRule = new ExceptionRule();
        exceptionRule.ip = ip;
        exceptionRule.exceptionIpType = exceptionIpType;
        exceptionRule.dayOfWeeks = dayOfWeeks;
        exceptionRule.startDay = startDay;
        exceptionRule.endDay = endDay;
        exceptionRule.startTime = startTime;
        exceptionRule.endTime = endTime;
        return exceptionRule;
    }

    public String getIp() {
        return ip;
    }

    public ExceptionIpType getExceptionIpType() {
        return exceptionIpType;
    }

    public List<DayOfWeek> getDayOfWeeks() {
        return dayOfWeeks;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean isActiveAt(LocalDateTime now){
        LocalDate nowDate = now.toLocalDate();
        LocalTime nowTime = now.toLocalTime();

        if (nowDate.isBefore(startDay) || nowDate.isAfter(endDay)) {
            return false;
        }

        if (nowTime.isBefore(startTime) || nowTime.isAfter(endTime)) {
            return false;
        }

        return switch (exceptionIpType) {
            case DAILY -> true;
            case WEEKLY, MONTHLY -> dayOfWeeks != null && dayOfWeeks.contains(now.getDayOfWeek());
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionRule that = (ExceptionRule) o;
        return Objects.equals(ip, that.ip) && exceptionIpType == that.exceptionIpType && Objects.equals(dayOfWeeks, that.dayOfWeeks) && Objects.equals(startDay, that.startDay) && Objects.equals(endDay, that.endDay) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, exceptionIpType, dayOfWeeks, startDay, endDay, startTime, endTime);
    }
}
