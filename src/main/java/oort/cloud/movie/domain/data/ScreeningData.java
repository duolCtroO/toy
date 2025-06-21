package oort.cloud.movie.domain.data;

import oort.cloud.movie.domain.Customer;
import oort.cloud.movie.domain.Money;
import oort.cloud.movie.domain.Reservation;

import java.time.LocalDateTime;

public class ScreeningData {
    private MovieData movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public ReservationData reserve(Customer customer, int audienceCnt){
        return new ReservationData(customer, this, calculateFee(audienceCnt), audienceCnt);
    }
    public Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
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
