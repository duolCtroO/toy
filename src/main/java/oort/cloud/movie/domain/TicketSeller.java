package oort.cloud.movie.domain;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        Ticket ticket = ticketOffice.getTicket();
        ticketOffice.plusAmount(audience.buy(ticket));
    }

    @Override
    public String toString() {
        return "TicketSeller{" +
                "ticketOffice=" + ticketOffice +
                '}';
    }
}
