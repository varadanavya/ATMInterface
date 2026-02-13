import java.util.*;

public class ATMSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static User currentUser = null;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void createAccount() {

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        users.add(new User(username, password));

        System.out.println("Account Created Successfully!");
    }

    static void login() {

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                System.out.println("Login Successful!");
                atmMenu();
                return;
            }
        }

        System.out.println("Invalid Login Details!");
    }

    static void atmMenu() {

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: " + currentUser.balance);
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    double deposit = sc.nextDouble();
                    currentUser.balance += deposit;
                    System.out.println("Deposit Successful");
                    break;

                case 3:
                    System.out.print("Enter Amount: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= currentUser.balance) {
                        currentUser.balance -= withdraw;
                        System.out.println("Withdrawal Successful");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 4:
                    System.out.println("Logged Out");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
