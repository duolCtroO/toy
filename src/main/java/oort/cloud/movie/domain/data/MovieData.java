package oort.cloud.movie.domain.data;
import oort.cloud.movie.domain.Money;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class MovieData {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateAmountDiscountedFee(){
        if(!movieType.equals(MovieType.AMOUNT_DISCOUNT)){
            throw new IllegalArgumentException("잘못된 영화 유형 입니다.");
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee(){
        if(!movieType.equals(MovieType.PERCENT_DISCOUNT)){
            throw new IllegalArgumentException("잘못된 영화 유형 입니다.");
        }
        return fee.times(discountPercent);
    }

    public Money calculateNoneDiscountedFee(){
        if(!movieType.equals(MovieType.PERCENT_DISCOUNT)){
            throw new IllegalArgumentException("잘못된 영화 유형 입니다.");
        }
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence){
        for (DiscountCondition condition : discountConditions) {
            if(condition.getType() == DiscountConditionType.PERIOD){
                if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())){
                    return true;
                }
            }else{
                if(condition.isDiscountable(sequence)){
                    return true;
                }
            }
        }
        return false;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Money calculateMovieFee(ScreeningData screeningData) {
        if(isDiscountable(screeningData)){
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private Money calculateDiscountAmount() {
        return switch (this.getMovieType()){
            case AMOUNT_DISCOUNT ->
                    this.calculateAmountDiscountedFee();
            case PERCENT_DISCOUNT ->
                    this.calculatePercentDiscountedFee();
            default ->
                    this.calculateNoneDiscountedFee();
        };
    }

    private boolean isDiscountable(ScreeningData screeningData){
        return discountConditions.stream()
                .anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screeningData));
    }
}
