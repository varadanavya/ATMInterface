import java.util.Scanner;
class ATMInterface {

    static double balance = 1000;
    static String userID;
    static int userPIN;

    static void checkBalance() {
        System.out.println("Your Balance: " + balance);
    }

    static void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔐 CREATE ACCOUNT
        System.out.println("===== CREATE ATM ACCOUNT =====");
        System.out.print("Create User ID: ");
        userID = sc.next();

        System.out.print("Create PIN: ");
        userPIN = sc.nextInt();

        // 🔐 LOGIN
        System.out.println("\n===== LOGIN =====");
        System.out.print("Enter User ID: ");
        String loginID = sc.next();

        System.out.print("Enter PIN: ");
        int loginPIN = sc.nextInt();

        if (!loginID.equals(userID) || loginPIN != userPIN) {
            System.out.println("Invalid Login Details");
            sc.close();
            return;
        }

        System.out.println("\nLogin Successful 👍");

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wd = sc.nextDouble();
                    withdraw(wd);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
