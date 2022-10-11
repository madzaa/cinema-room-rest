package cinema.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cinema {
    private final int totalRows;
    private final int totalColumns;

    private final List<Seat> cinemaRoomSeats;

    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.cinemaRoomSeats = new ArrayList<>();
        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                cinemaRoomSeats.add(new Seat(i, j, Status.AVAILABLE));
            }
        }
    }

    public List<Seat> getAvailableSeats() {
        return cinemaRoomSeats;
    }

    public int getTotalRows () {
        return totalRows;
    }

    public int getTotalColumns () {
        return totalColumns;
    }

    @Override
    public boolean equals (Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Cinema) obj;
        return this.totalRows == that.totalRows &&
                this.totalColumns == that.totalColumns;
    }

    @Override
    public int hashCode () {
        return Objects.hash(totalRows, totalColumns);
    }

    @Override
    public String toString () {
        return "Cinema[" +
                "totalRows=" + totalRows + ", " +
                "totalColumns=" + totalColumns + ']';
    }

}