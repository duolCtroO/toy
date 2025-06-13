package oort.cloud.movie.domain;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        ticketOffice.sellTicketTo(audience);
    }

    @Override
    public String toString() {
        return "TicketSeller{" +
                "ticketOffice=" + ticketOffice +
                '}';
    }
}
