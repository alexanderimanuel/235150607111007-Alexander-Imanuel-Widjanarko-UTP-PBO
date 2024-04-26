public class Movie {
    private String title;
    private double rating;
    private String[] genres;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
        this.genres = new String[0]; // Initialize with an empty array if no genres are provided
    }

    public Movie(String title, double rating, String[] genres) {
        this.title = title;
        this.rating = rating;
        this.genres = genres; // Initialize with the provided array of genres
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
}
