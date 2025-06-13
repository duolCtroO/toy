package oort.cloud.movie.domain;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public int buy(Ticket ticket){
        return bag.hold(ticket);
    }

    @Override
    public String toString() {
        return "Audience{" +
                "bag=" + bag +
                '}';
    }
}
