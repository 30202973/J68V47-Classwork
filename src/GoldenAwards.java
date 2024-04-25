import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldenAwards {
    public static class StudentSignIn {
        static class Account {
            String username;
            String password;
            int totalPoints;

            public Account(String username, String password) {
                this.username = username;
                this.password = password;
                this.totalPoints = 0;
            }
            public int getTotalPoints() {
                return totalPoints;
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
                        String username = parts[0];
                        String password = parts[1];
                        int totalPoints = Integer.parseInt(parts[2]);
                        Account loadedUser = new Account(username, password);
                        loadedUser.totalPoints = totalPoints;
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


        public static void studentSignIn() {
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
                    System.out.println("Sign in successful. Welcome, " + studentUsername + "!\n");
                    currentUser = getAccount(studentUsername, Accounts);

                    // Display actual points
                    System.out.println("Points: " + currentUser.getTotalPoints());
                } else {
                    System.out.println("Error: Invalid information. Please try again.");
                }
            }
        }


    }

    static class TeacherSignIn {
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
                totalPoints += points;
            }

        }

        static class Teacher {
            String username;
            String password;

            public Teacher(String username, String password) {
                this.username = username;
                this.password = password;
            }

            public void assignPoints(AwardPointTrackingSystem.Account student, int points, String field, String reason) {
                student.addPoints(points);
                System.out.println("Points assigned to " + student.getUsername() + ": " + points + " for " + field + " - " + reason);
            }
        }

        private static boolean isCorrectSignIn(String teacherUsername, String teacherPassword, List<AwardPointTrackingSystem.Teacher> Teachers) {
            for (AwardPointTrackingSystem.Teacher TeacherUser : Teachers) {
                if (teacherUsername.equals(TeacherUser.username) && teacherPassword.equals(TeacherUser.password)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isCorrectSignIn(String studentUsername, List<AwardPointTrackingSystem.Account> Accounts) {
            for (AwardPointTrackingSystem.Account StudentUser : Accounts) {
                if (studentUsername.equals(StudentUser.username)) {
                    return true;
                }
            }
            return false;
        }

        private static List<AwardPointTrackingSystem.Account> getAccounts() {
            List<AwardPointTrackingSystem.Account> getAccounts = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File("src/Accounts.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        AwardPointTrackingSystem.Account loadedStudentUser = new AwardPointTrackingSystem.Account(parts[0], parts[1]);
                        getAccounts.add(loadedStudentUser);
                    }
                }
            } catch (FileNotFoundException e) {
            }
            return getAccounts;
        }

        private static List<AwardPointTrackingSystem.Teacher> getTeachers() {
            List<AwardPointTrackingSystem.Teacher> getTeachers = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File("src/Teacher.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        AwardPointTrackingSystem.Teacher loadTeacherUser = new AwardPointTrackingSystem.Teacher(parts[0], parts[1]);
                        getTeachers.add(loadTeacherUser);
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error: Teacher file not found.");
            }
            return getTeachers;

        }

        private static AwardPointTrackingSystem.Account getAccount(String username, List<AwardPointTrackingSystem.Account> Accounts) {
            for (AwardPointTrackingSystem.Account StudentUser : Accounts) {
                if (StudentUser.username.equals(username)) {
                    return StudentUser;
                }
            }
            return null;
        }

        private static AwardPointTrackingSystem.Teacher getTeacher(String username, List<AwardPointTrackingSystem.Teacher> Teachers) {
            for (AwardPointTrackingSystem.Teacher TeacherUser : Teachers) {
                if (TeacherUser.username.equals(username)) {
                    return TeacherUser;
                }
            }
            return null;
        }

        public static void teacherSignIn() {
            Scanner scanner = new Scanner(System.in);
            List<AwardPointTrackingSystem.Account> Accounts = getAccounts();
            AwardPointTrackingSystem.Account currentStudentUser = null;

            List<AwardPointTrackingSystem.Teacher> Teachers = getTeachers();
            AwardPointTrackingSystem.Teacher currentTeacherUser = null;

            boolean TeacherSignInSuccessful = false;

            while (!TeacherSignInSuccessful) {
                System.out.println("\n" +"Teacher Login");
                System.out.print("Username: ");
                String teacherUsername = scanner.nextLine();
                System.out.print("Password: ");
                String teacherPassword = scanner.nextLine();

                TeacherSignInSuccessful = isCorrectSignIn(teacherUsername, teacherPassword, Teachers);

                if (TeacherSignInSuccessful) {
                    currentTeacherUser = getTeacher(teacherUsername, Teachers);

                    boolean StudentUserCorrect = false;
                    System.out.print("\n" + "!!Welcome!!" + "\n");

                    while (!StudentUserCorrect) {
                        System.out.print( "\n" + "Assign a student"+ "\n");
                        System.out.print("Student Username: ");
                        String studentUsername = scanner.nextLine();
                        StudentUserCorrect = isCorrectSignIn(studentUsername, Accounts);

                        if (StudentUserCorrect) {
                            AwardPointTrackingSystem.Account selectedStudent = getAccount(studentUsername, Accounts);

                            int points;

                            while (true) {
                                System.out.print("Points (100 or 0): ");
                                points = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                if (points == 100 || points == 0) {
                                    break;
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

                        } else {
                            System.out.println("Student not found. Please try again.");
                        }
                    }
                } else {
                    System.out.println("Invalid credentials.");
                }

            }
        }



        private static void updatePointsInFile(AwardPointTrackingSystem.Account selectedStudent, int points) {
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
                        int currentPoints = Integer.parseInt(parts[2]);
                        int newTotalPoints = currentPoints + points;
                        parts[2] = Integer.toString(newTotalPoints);
                        lines.set(i, String.join(",", parts));
                        break;
                    }
                }

                try (PrintWriter writer = new PrintWriter(file)) {
                    for (String updatedLine : lines) {
                        writer.println(updatedLine);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("!                               (100)   ~GOLDEN AWARDS~   (100)                        ! ");
        System.out.println(":                                          Sign in:                                    :");
        System.out.println("!                                  Enter \"T\" for teacher                               !");
        System.out.println(":                                  Enter \"S\" for student                               !");
        System.out.println("!                                                                                      :");
        System.out.println(":                                                                                      !");
        System.out.println("!                                                                                      :");
        System.out.println(":                                                                                      !");
        System.out.println("!                                                                                      :");
        System.out.println(":                                                                                      !");
        System.out.println("----------------------------------------------------------------------------------------");

        while (continueProgram) {
            System.out.println("\nEnter your choice (\"T\" for teacher, \"S\" for student, or \"Q\" to quit): ");
            String choice = scanner.nextLine();

            switch (choice.toUpperCase()) {
                case "S":
                    // Student login
                    StudentSignIn.studentSignIn();
                    break;
                case "T":
                    // Teacher login
                    TeacherSignIn.teacherSignIn();
                    break;
                case "Q":
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter \"T\" for teacher, \"S\" for student, or \"Q\" to quit.");
            }
        }

    }
}