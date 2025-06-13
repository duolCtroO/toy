package oort.cloud.movie.domain;

public class Bag {
    private Ticket ticket;
    private int amount;
    private Invitation invitation;

    public Bag(int amount){
        this(amount, null);
    }

    public Bag(int amount, Invitation invitation){
        this.amount = amount;
        this.invitation = invitation;
    }

    public int hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0;
        }else{
            minusAmount(ticket.getPrice());
            setTicket(ticket);
            return ticket.getPrice();
        }
    }

    public boolean hasInvitation(){
        return invitation != null;
    }

    public boolean hasTicket(){
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getAmount() {
        return amount;
    }

    private void minusAmount(int amount){
        this.amount -= amount;
    }

    private void plusAmount(int amount){
        this.amount += amount;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "ticket=" + ticket +
                ", amount=" + amount +
                ", invitation=" + invitation +
                '}';
    }
}
