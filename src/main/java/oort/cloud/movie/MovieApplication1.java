package oort.cloud.movie;

import oort.cloud.movie.domain.*;
import java.time.LocalDate;

public class MovieApplication1 {
    public static void main(String[] args) {
        System.out.println("Movie Application Start...");
        TicketOffice ticketOffice = new TicketOffice(10000,
                new Ticket(1, 1000, 10),
                new Ticket(2, 1000, 11),
                new Ticket(3, 1000, 12)
        );

        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Audience audience1 = new Audience(
                new Bag(10000, new Invitation(1, LocalDate.now())));
        Audience audience2 = new Audience(
                new Bag(10000));

        MovieTheater movieTheater = new MovieTheater(ticketSeller);
        movieTheater.enter(audience1);
        movieTheater.enter(audience2);

        System.out.println(audience1);
        System.out.println(audience2);
        System.out.println(ticketSeller);
    }
}
