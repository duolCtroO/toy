package oort.cloud.movie.domain;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public int buy(Ticket ticket){
        if(bag.hasInvitation()){
            bag.setTicket(ticket);
            return 0;
        }else{
            bag.minusAmount(ticket.getPrice());
            bag.setTicket(ticket);
            return ticket.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Audience{" +
                "bag=" + bag +
                '}';
    }
}
