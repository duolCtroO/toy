package oort.cloud.movie.domain.data;

import oort.cloud.movie.domain.Money;

import java.time.LocalDateTime;

public class ScreeningData {
    private MovieData movie;
    private int sequence;
    private LocalDateTime whenScreened;


    public Money calculateFee(int audienceCount){
        if(!movie.isDiscountable(whenScreened, sequence))
            return movie.calculateNoneDiscountedFee();

        return switch (movie.getMovieType()){
            case AMOUNT_DISCOUNT ->
                    movie.calculateAmountDiscountedFee().times(audienceCount);
            case PERCENT_DISCOUNT ->
                    movie.calculatePercentDiscountedFee().times(audienceCount);
            default ->
                movie.calculateNoneDiscountedFee().times(audienceCount);
        };
    }
    public MovieData getMovie() {
        return movie;
    }

    public void setMovie(MovieData movie) {
        this.movie = movie;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }
}
