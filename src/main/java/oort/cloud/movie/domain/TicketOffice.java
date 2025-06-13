package oort.cloud.movie.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private int amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(int amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void sellTicketTo(Audience audience){
        Ticket ticket = getTicket();
        plusAmount(ticket.getPrice());
        audience.buy(ticket);
    }

    private Ticket getTicket(){
        return tickets.remove(0);
    }

    public void minusAmount(int amount){
        this.amount -= amount;
    }

    public void plusAmount(int amount){
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "TicketOffice{" +
                "amount=" + amount +
                ", tickets=" + tickets +
                '}';
    }
}
