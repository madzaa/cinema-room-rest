package cinema.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public final class Seat {
    private final int row;
    private final int column;
    private final int price;
    private Status status;

    public Seat(@JsonProperty("row") int row,  @JsonProperty("column") int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
    }

    @JsonCreator
    public Seat(@JsonProperty("row") int row, @JsonProperty("column") int column, @JsonProperty("status") Status status) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.status = status;
    }

    @JsonIgnore
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    @JsonProperty("row")
    public int getRow() {
        return row;
    }

    @JsonProperty("column")
    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Seat) obj;
        return this.row == that.row &&
                this.column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, price);
    }

    @Override
    public String toString() {
        return "Seat[" +
                "row=" + row + ", " +
                "column=" + column + ", " +
                "price=" + price + ']';
    }
}