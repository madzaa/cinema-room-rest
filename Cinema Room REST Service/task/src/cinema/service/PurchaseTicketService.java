package cinema.service;

import cinema.model.Seat;
import cinema.model.Status;
import cinema.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class PurchaseTicketService {

    public ReturnTicketService returnTicketService;

    public PurchaseTicketService() {
        this.returnTicketService = new ReturnTicketService();
    }

    public boolean checkBooking(Seat seat) {
        return seat.getStatus().equals(Status.UNAVAILABLE);
    }

    public void bookSeat(Seat seat) {
        seat.setStatus(Status.UNAVAILABLE);
    }

    public boolean inBounds(Seat seat) {
        return seat.getRow() > 9
                || seat.getColumn() > 9
                || seat.getRow() < 0
                || seat.getColumn() < 0;
    }

    public ResponseEntity outOfBounds() {
        return new ResponseEntity<>(
                Map.of(
                        "error", Status
                                .OUT_OF_BOUNDS
                                .toString()
                ),
                HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity seatAlreadyBooked() {
            return new ResponseEntity<>(
                    Map.of(
                            "error", Status
                                    .UNAVAILABLE
                                    .toString()
                    ),
                    HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity purchaseTicket(Seat seat) {

        bookSeat(seat);

        Ticket ticket = new Ticket(seat);

        returnTicketService.addTicket(ticket);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
