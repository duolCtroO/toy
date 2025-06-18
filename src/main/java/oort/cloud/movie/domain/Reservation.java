package oort.cloud.movie.domain;

public class Reservation {
    private final Customer customer;
    private final Screening screening;
    private final Money fee;
    private final int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.fee = fee;
        this.screening = screening;
        this.customer = customer;
        this.audienceCount = audienceCount;
    }
}
