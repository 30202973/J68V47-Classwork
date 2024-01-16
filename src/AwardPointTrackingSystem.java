import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class AwardPointTrackingSystem {
    public class Accounts {
        private String username;
        private String password;
        private int totalPoints;

        public Accounts(String username, String password) {
            this.username = username;
            this.password = password;
            this.totalPoints = 0;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void addPoints(int points) {
            totalPoints += points;
        }
        public static class Teacher {
            private String teacherUsername;
            private String teacherPassword;

            public Teacher(String username, String password) {
                this.teacherUsername = username;
                this.teacherPassword = password;
            }

            public String getUsername() {
                return teacherUsername;
            }

            public String getPassword() {
                return teacherPassword;
            }

            public void assignPoints(Accounts student, int points, String field, String reason) {
                // Logic to assign points and update records
                student.addPoints(points);
                // Record transaction in the system
                System.out.println("Points assigned to " + student.getUsername() + ": " + points + " for " + field + " - " + reason);
            }

        }

    }

    public static void main(String[] args) {
        AwardPointTrackingSystem awardPointSystem = new AwardPointTrackingSystem();

        // Load teacher credentials from file
        loadStudents(awardPointSystem, "src/Accounts.txt");
        loadTeachers(awardPointSystem, "src/Teacher.txt");

        Scanner scanner = new Scanner(System.in);

        // Sample teacher login
        System.out.println("Teacher Login");
        System.out.print("Username: ");
        String teacherUsername = scanner.nextLine();
        System.out.print("Password: ");
        String teacherPassword = scanner.nextLine();


        Teacher loggedInTeacher = awardPointSystem.getTeacher(teacherUsername, teacherPassword);

        if (teacherUsername.equals(teacherUsername) && teacherPassword.equals(teacherPassword)) {
            System.out.println("Login successful!");

            // Ask for student username and check if it exists
            Accounts selectedStudent;

            do {
                System.out.print("Student Username: ");
                String studentUsername = scanner.nextLine();
                selectedStudent = awardPointSystem.getStudent(studentUsername);

                if (selectedStudent == null) {
                    System.out.println("Student not found. Please try again.");
                }
            } while (selectedStudent == null);
                // Assign points
                System.out.print("Points (100 or 0): ");
                int points = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Field (Behaviours, Grades, Attendances, School Activities): ");
                String field = scanner.nextLine();

                System.out.print("Reason: ");
                String reason = scanner.nextLine();

                // Record the transaction
                loggedInTeacher.assignPoints(selectedStudent, points, field, reason);

                // Update the "Accounts.txt" file with the new points
                updatePointsInFile(selectedStudent, points);

                System.out.println("Total Points for " + selectedStudent.getUsername() + ": " + selectedStudent.getTotalPoints());

        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }

    private Accounts getStudent(String studentUsername) {
        return null;
    }

    private Teacher getTeacher(String teacherUsername, String teacherPassword) {
        return null;
    }

    private static void loadStudents(AwardPointTrackingSystem awardPointSystem, String filename) {
        try (Scanner scanner = new Scanner(new File("src/Accounts.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Student loadedStudent = new Student(parts[0], parts[1]);
                    awardPointSystem.addStudent(loadedStudent);
                }
            }
        }
    }

    private void addStudent(Student loadedStudent) {
    }

    private static void loadTeachers(AwardPointTrackingSystem awardPointSystem, String filename) {
        try (Scanner scanner = new Scanner(new File("src/Teacher.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Teacher loadTeacher = new Teacher(parts[0], parts[1]);
                    awardPointSystem.addTeacher(loadTeacher);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Teacher file not found.");
        }
    }

    private void addTeacher(Teacher loadTeacher) {
    }


    private static void updatePointsInFile(Accounts student, int points) {
        // Implement the method to update points in the file
    }

    // Define getTeacher, getStudent, assignPoints, getUsername, and getTotalPoints methods here
}