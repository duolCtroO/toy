package oort.cloud.movie.domain;

public class MovieTheater {
    private final TicketSeller ticketSeller;

    public MovieTheater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
