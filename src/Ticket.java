public class Ticket {
    private Movie movie;
    private int studioNumber;
    private double price;
    private String seat;

    public Ticket(Movie movie, int studioNumber, String seat) {
        this.movie = movie;
        this.studioNumber = studioNumber;
        this.seat = seat;
        this.price = getTicketPrice(movie.getTitle()); 
    }

    public String getTicketInfo() {
        return "Movie: " + movie.getTitle() + ", Studio: " + studioNumber + ", Seat: " + seat + ", Price: " + price;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStudioNumber() {
        return studioNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getSeat() {
        return seat;
    }

    // The getTicketPrice method remains unchanged
    public static double getTicketPrice(String type) {
        switch (type) {
            case "Premiere":
                return 120000;
            case "Imax":
                return 100000;
            default:
                return 50000;
        }
    }
}
