import java.io.*;
import java.util.*;
public class draft {
    static class Account {
        String username;
        String password;
        public Account(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
    private static boolean isCorrectSignIn(String studentUsername, String studentPassword, List<Account> Accounts) {
        for (Account user : Accounts) {
            if (studentUsername.equals(user.username) && studentPassword.equals(user.password)) {
                return true;
            }
        }
        return false;
    }
    private static List<Account> getAccounts() {
        List<Account> getAccounts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/Accounts.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Account loadedUser = new Account(parts[0], parts[1]);
                    getAccounts.add(loadedUser);
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist, ignore
        }
        return getAccounts;
    }
    private static Account getAccount(String username, List<Account> Accounts) {
        for (Account user : Accounts) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> Accounts = getAccounts();
        Account currentUser = null;

        boolean signInSuccessful = false;

        while (!signInSuccessful) {
            System.out.println("\nSign in");
            System.out.print("Username: ");
            String studentUsername = scanner.nextLine();
            System.out.print("Password: ");
            String studentPassword = scanner.nextLine();

            signInSuccessful = isCorrectSignIn(studentUsername, studentPassword, Accounts);


            if (signInSuccessful) {
                System.out.println("Sigh in successful. Welcome, " + studentUsername + "!\n");
                currentUser = getAccount(studentUsername, Accounts);

            } else {
                System.out.println("Error: Invalid information. Please try again.");
            }
        }
    }

}