package cinema.service;

import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.util.MatchUtil;
import org.springframework.http.ResponseEntity;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CinemaService {

    public final Cinema cinema;
    public PurchaseTicketService purchaseTicketService;

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public CinemaService() {
        this.cinema = new Cinema(9, 9);
        this.purchaseTicketService = new PurchaseTicketService();
    }

    public Cinema getSeats() {
        return cinema;
    }

    public ResponseEntity purchaseTicket(Seat seat) {
        if (purchaseTicketService.inBounds(seat)) {
            return purchaseTicketService.outOfBounds();
        }

        Seat matchedSeat = MatchUtil.matchObject(seat, cinema.getAvailableSeats());

        if (purchaseTicketService.checkBooking(matchedSeat)) {
            return purchaseTicketService.seatAlreadyBooked();
        } else {
            LOGGER.log(Level.INFO, "Ticket bought!");
            return purchaseTicketService.purchaseTicket(matchedSeat);
        }
    }

    public Ticket returnTicket(Ticket ticket) {
        LOGGER.log(Level.INFO, "Looking for return ticket!");

        Ticket matchedTicket = MatchUtil.matchObject(ticket,
                purchaseTicketService
                        .returnTicketService
                        .ticketArray);
        System.out.println(matchedTicket.toString());

        LOGGER.log(Level.INFO, matchedTicket.toString());

        return matchedTicket;
    }
}