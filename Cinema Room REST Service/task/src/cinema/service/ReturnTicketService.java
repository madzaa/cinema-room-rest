package cinema.service;

import cinema.model.Status;
import cinema.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReturnTicketService {


    public final List<Ticket> ticketArray;

    public ReturnTicketService() {
        this.ticketArray = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        ticketArray.add(ticket);
    }

    public Ticket getTicket(Ticket ticket) {
        if (!ticketArray.contains(ticket)) {
            throw new RuntimeException
                    (String.valueOf(wrongToken()));
        }

        for (Ticket bookedTicket : ticketArray) {
            if (bookedTicket.equals(ticket)) {
                removeTicket(ticket);
                return bookedTicket;
            }
        }
        return ticket;
    }

    public ResponseEntity wrongToken() {
            return new ResponseEntity<>(
                    Map.of(
                            "error", Status
                                    .WRONG_TOKEN
                                    .toString()
                    ),
                    HttpStatus.BAD_REQUEST);
    }

    public void removeTicket(Ticket ticket) {
        ticketArray.remove(ticket);
    }
}
