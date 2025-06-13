package oort.cloud.movie.domain;

public class Ticket {
    private final int ticketId;
    private final int price;
    private final int seatNumber;

    public Ticket(int ticketId, int price, int seatNumber) {
        this.ticketId = ticketId;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getPrice() {
        return price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
