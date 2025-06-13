package oort.cloud.movie.domain;

public class Bag {
    private Ticket ticket;
    private int amount;
    private Invitation invitation;

    public Bag(int amount){
        this(null, amount, null);
    }

    public Bag(int amount, Invitation invitation){
        this(null, amount, invitation);
    }

    public Bag(Ticket ticket, int amount, Invitation invitation) {
        this.ticket = ticket;
        this.amount = amount;
        this.invitation = invitation;
    }

    public boolean hasInvitation(){
        return invitation != null;
    }

    public boolean hasTicket(){
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void minusAmount(int amount){
        this.amount -= amount;
    }

    public void plusAmount(int amount){
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
