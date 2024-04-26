public class Studio {
    private Movie movie;
    private String type;
    private boolean[][] seats;

    public Studio(String type, Movie movie) {
        this.type = type;
        this.movie = movie;
        setSeats(); // Initialize seats based on the type of studio
    }

    private void setSeats() {
        int rows;
        int cols;
        switch (this.type) {
            case "Imax":
                rows = 8;
                cols = 9;
                break;
            case "Premiere":
                rows = 6;
                cols = 4;
                break;
            default: // Assuming "Reguler" as default
                rows = 5;
                cols = 5;
                break;
        }
        seats = new boolean[rows][cols];
    }

    public String getStudioInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Studio Type: ").append(type).append("\n");
        info.append("Movie: ").append(movie.getTitle()).append("\n");
        // Add more details as needed
        return info.toString();
    }

    public boolean isBooked(char row, int col) {
        int rowIndex = row - 'A';
        if (rowIndex >= 0 && rowIndex < seats.length && col >= 0 && col < seats[rowIndex].length) {
            return seats[rowIndex][col];
        }
        return false; // Return false if the seat is not booked or indices are out of bounds
    }

    public boolean reserve(char row, int col) {
        int rowIndex = row - 'A';
        if (rowIndex >= 0 && rowIndex < seats.length && col >= 0 && col < seats[rowIndex].length && !seats[rowIndex][col]) {
            seats[rowIndex][col] = true;
            return true;
        }
        return false; // Return false if the seat is already booked or indices are out of bounds
    }

    public String getType() {
        return type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
