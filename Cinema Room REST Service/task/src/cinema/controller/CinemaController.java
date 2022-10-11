package cinema.controller;

import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.service.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class CinemaController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final CinemaService cinemaService = new CinemaService();

    @GetMapping("/seats")
    public Cinema cinemaList() {
        return cinemaService.getSeats();
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseSeat(@RequestBody Seat seat) {
        return cinemaService.purchaseTicket(seat);
    }

    @PostMapping("/return")
    public Ticket returnTicket(@RequestBody Ticket ticket) {
        LOGGER.log(Level.INFO, "Starting the return ticket service!");
        return cinemaService.returnTicket(ticket);
    }
}