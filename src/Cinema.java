public class Cinema {
    private String name;
    private User[] listUsers;
    private Studio[] listStudio;
    private int studioCapacity;

    public Cinema(String name, int studioCapacity) {
        this.name = name;
        this.studioCapacity = studioCapacity;
        this.listUsers = new User[100]; 
        this.listStudio = new Studio[studioCapacity]; 
        init(); 
    }

    private void init() {
        for (int i = 0; i < studioCapacity; i++) {
            addStudioWithMovies("Reguler", "Movie " + (i + 1), 7.0 + i, new String[]{"Genre1", "Genre2"});
        }
    }

    public boolean registerUser(User user) {
        for (int i = 0; i < listUsers.length; i++) {
            if (listUsers[i] == null) {
                listUsers[i] = user;
                return true;
            }
        }
        return false;
    }

    public User authenticateUser(String email, String password) {
        for (User user : listUsers) {
            if (user != null && user.isMatch(email, password)) {
                return user;
            }
        }
        return null;
    }

    public void displayListStudio() {
        for (int i = 0; i < listStudio.length; i++) {
            if (listStudio[i] != null) {
                System.out.println("Studio " + (i + 1) + ": " + listStudio[i].getType() + " - " + listStudio[i].getMovie().getTitle());
            }
        }
    }

    public void displayStudioDetail(int studioNumber) {
        if (studioNumber > 0 && studioNumber <= listStudio.length && listStudio[studioNumber - 1] != null) {
            System.out.println(listStudio[studioNumber - 1].getStudioInfo());
        } else {
            System.out.println("Studio number is invalid or does not exist.");
        }
    }

    public boolean addStudioWithMovies(String studioType, String movieTitle, double movieRating, String[] movieGenres) {
        for (int i = 0; i < listStudio.length; i++) {
            if (listStudio[i] == null) {
                listStudio[i] = new Studio(studioType, new Movie(movieTitle, movieRating, movieGenres));
                return true;
            }
        }
        return false;
    }

    public boolean bookTicket(User user, int studioNumber, char row, int col) {

        if (studioNumber > 0 && studioNumber <= listStudio.length) {
            Studio studio = listStudio[studioNumber - 1];
            if (studio != null && !studio.isBooked(row, col)) {
                Ticket ticket = new Ticket(studio.getMovie(), studioNumber, String.valueOf(row) + col);
                if (user.addTicket(ticket)) {
                    studio.reserve(row, col);
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}