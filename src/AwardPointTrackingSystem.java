import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
public class AwardPointTrackingSystem {
    static class Account {

        String username;
        int totalPoints;

        public Account(String username, String part) {
            this.username = username;
            this.totalPoints = 0;
        }

        public String getUsername() {
            return username;
        }


        public int getTotalPoints() {
            return totalPoints;
        }

        public void addPoints(int points) {
            if (points == 100) {
                totalPoints += points;
            }
        }

        public int totalPoints() {
            return 0;
        }
    }

    static class Teacher {
        String username;
        String password;

        public Teacher(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void assignPoints(Account student, int points, String field, String reason) {
            student.addPoints(points);
            System.out.println("Points assigned to " + student.getUsername() + ": " + points + " for " + field + " - " + reason);
        }
    }

    private static boolean isCorrectSignIn(String teacherUsername, String teacherPassword, List<Teacher> Teachers) {
        for (Teacher TeacherUser : Teachers) {
            if (teacherUsername.equals(TeacherUser.username) && teacherPassword.equals(TeacherUser.password)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorrectSignIn(String studentUsername, List<Account> Accounts) {
        for (Account StudentUser : Accounts) {
            if (studentUsername.equals(StudentUser.username)) {
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
                    Account loadedStudentUser = new Account(parts[0], parts[1]);
                    getAccounts.add(loadedStudentUser);
                }
            }
        } catch (FileNotFoundException e) {
        }
        return getAccounts;
    }

    private static List<Teacher> getTeachers() {
        List<Teacher> getTeachers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/Teacher.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Teacher loadTeacherUser = new Teacher(parts[0], parts[1]);
                    getTeachers.add(loadTeacherUser);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Teacher file not found.");
        }
        return getTeachers;

    }

    private static Account getAccount(String username, List<Account> Accounts) {
        for (Account StudentUser : Accounts) {
            if (StudentUser.username.equals(username)) {
                return StudentUser;
            }
        }
        return null;
    }

    private static Teacher getTeacher(String username, List<Teacher> Teachers) {
        for (Teacher TeacherUser : Teachers) {
            if (TeacherUser.username.equals(username)) {
                return TeacherUser;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> Accounts = getAccounts();
        Account currentStudentUser = null;

        List<Teacher> Teachers = getTeachers();
        Teacher currentTeacherUser = null;

        boolean TeacherSignInSuccessful = false;

        while (!TeacherSignInSuccessful) {
            System.out.println("Teacher Login");
            System.out.print("Username: ");
            String teacherUsername = scanner.nextLine();
            System.out.print("Password: ");
            String teacherPassword = scanner.nextLine();

            TeacherSignInSuccessful = isCorrectSignIn(teacherUsername, teacherPassword, Teachers);

            if (TeacherSignInSuccessful) {
                currentTeacherUser = getTeacher(teacherUsername, Teachers); // Assign the currentTeacherUser
                boolean StudentUserCorrect = false;

                while (!StudentUserCorrect) {
                    System.out.print("Student Username: ");
                    String studentUsername = scanner.nextLine();
                    StudentUserCorrect = isCorrectSignIn(studentUsername, Accounts);

                    if (StudentUserCorrect) {
                        Account selectedStudent = getAccount(studentUsername, Accounts);

                        int points;

                        while (true) {
                            System.out.print("Points (100 or 0): ");
                            points = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            if (points == 100 || points == 0) {
                                break; // Break out of the loop if the input is valid
                            } else {
                                System.out.println("Invalid input. Please enter 100 or 0.");
                            }
                        }
                        selectedStudent.addPoints(points);

                        System.out.print("Field (Behaviours, Grades, Attendances, School Activities): ");
                        String field = scanner.nextLine();
                        System.out.print("Reason: ");
                        String reason = scanner.nextLine();

                        currentTeacherUser.assignPoints(selectedStudent, points, field, reason);

                        updatePointsInFile(selectedStudent, points);

                    }else{System.out.println("Student not found. Please try again.");}
                }
            } else {
                System.out.println("Invalid credentials.");
            }

        }
        scanner.close();
    }


    private static void updatePointsInFile(Account selectedStudent, int points) {
        String filename = "src/Accounts.txt";

        try {
            List<String> lines = new ArrayList<>();
            File file = new File(filename);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
            }

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(selectedStudent.getUsername())) {
                    // Update the points for the selected student
                    parts[2] = Integer.toString(selectedStudent.getTotalPoints() + points);
                    lines.set(i, String.join(",", parts));
                    break; // No need to continue searching
                }
            }

            // Write the updated lines back to the file
            try (PrintWriter writer = new PrintWriter(file)) {
                for (String updatedLine : lines) {
                    writer.println(updatedLine);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

}