import java.util.Scanner;

public class Main {
    private static Cinema cinema;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cinema = new Cinema("Alexander", 10); 
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Alexander Cinema");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Pick your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    User user = login();
                    if (user != null) {
                        userMenu(user);
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static void register() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        User user = new User(email, password, fullName, balance);

        if (cinema.registerUser(user)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed.");
        }
    }

    private static User login() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = cinema.authenticateUser(email, password);
        if (user != null) {
            System.out.println("Login successful. Welcome, " + user.getFullName());
            return user;
        } else {
            System.out.println("Login failed.");
            return null;
        }
    }

    private static void userMenu(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("Welcome to Alexander Cinema");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Tampilkan Tiket milik Saya");
            System.out.println("3. lihat Studio yang Ada");
            System.out.println("4. Lihat Detail Studio");
            System.out.println("5. Top Up Saldo");
            System.out.println("6. Exit Program");
            System.out.print("Pick your choice : ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    bookTicket(user);
                    break;
                case 2:
                    user.displayAllTickets();
                    break;
                case 3:
                    cinema.displayListStudio();
                    break;
                case 4:
                    displayStudioDetails();
                    break;
                case 5:
                    topUpBalance(user);
                    break;
                case 6:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Salah hoy");
                    break;
            }
        }
    }

    private static void topUpBalance(User user) {
        System.out.print("Masukkan saldo yang ingin ditopup: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        user.setBalance(amount);
        System.out.println("Top Up berhasil Uhuyyy. Saldo anda sekarang Rp" + user.getBalance());
    }

    private static void displayStudioDetails() {
        System.out.print("Enter studio number: ");
        int studioNumber = scanner.nextInt();
        scanner.nextLine(); 
        cinema.displayStudioDetail(studioNumber);
    }

    private static void bookTicket(User user) {
        System.out.print("Enter studio number: ");
        int studioNumber = scanner.nextInt();
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter column letter: ");
        char col = scanner.next().charAt(0);
        scanner.nextLine(); 

        if (cinema.bookTicket(user, studioNumber, row, col)) {
            System.out.println("berhasilll");
        } else {
            System.out.println("Failed");
        }
    }
}
