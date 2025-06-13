package oort.cloud.movie.domain;

public class MovieTheater {
    private final TicketSeller ticketSeller;

    public MovieTheater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        TicketOffice ticketOffice = ticketSeller.getTicketOffice();

        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getPrice());
            ticketOffice.plusAmount(ticket.getPrice());
            audience.getBag().setTicket(ticket);
        }
    }
}
