package cinema.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.el.parser.Token;

import java.util.Objects;
import java.util.UUID;

public final class Ticket {
    private String token;

    private Seat seat;
    @JsonCreator
    public Ticket(@JsonProperty("seat") Seat seat) {
        this.token = UUID.randomUUID().toString();
        this.seat = seat;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Ticket(@JsonProperty("token") String token) {
        this.token = token;
    }

    public Ticket() {
        super();
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("ticket")
    public Seat getSeat() {
        return seat;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return getToken().equals(ticket.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToken());
    }
}