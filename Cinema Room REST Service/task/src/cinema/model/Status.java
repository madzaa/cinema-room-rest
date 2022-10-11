package cinema.model;

public enum Status {
    AVAILABLE("Available"),
    OUT_OF_BOUNDS("The number of a row or a column is out of bounds!"),
    UNAVAILABLE("The ticket has been already purchased!"),

    WRONG_TOKEN("Wrong Token!");

    final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}