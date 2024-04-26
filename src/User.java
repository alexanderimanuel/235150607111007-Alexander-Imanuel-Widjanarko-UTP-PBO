public class User {
    private String email;
    private String password;
    private String fullName;
    private double balance;
    private Ticket[] ticketLists;
    private static final int MAX_TICKET = 20; // Assuming the maximum number of tickets per user is 20

    public User(String email, String password, String fullName, double balance) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.ticketLists = new Ticket[MAX_TICKET];
    }

    public boolean addTicket(Ticket ticket) {
        if (this.balance >= ticket.getPrice()) {
            for (int i = 0; i < MAX_TICKET; i++) {
                if (ticketLists[i] == null) {
                    ticketLists[i] = ticket;
                    this.balance -= ticket.getPrice(); // Deduct the ticket price from the user's balance
                    return true;
                }
            }
        }
        return false;
    }

    public void displayAllTickets() {
        System.out.println("Tickets for " + getFullName() + ":");
        for (Ticket ticket : ticketLists) {
            if (ticket != null) {
                System.out.println(ticket.getTicketInfo());
            }
        }
    }

    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance -= balance;
    }
}
