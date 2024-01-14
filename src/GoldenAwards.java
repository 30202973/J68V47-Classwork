import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Accounts extends User {
    public Object id;
    private int totalPoints;

    public Accounts(String username, String password) {
        super(username, password);
        this.totalPoints = 0;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addPoints(int points) {
        totalPoints += points;
    }
}

class Teacher extends User {
    public Teacher(String username, String password) {
        super(username, password);
    }

    public void assignPoints(Accounts student, int points, String field, String reason) {
        // Logic to assign points and update records
        student.addPoints(points);
        // Record transaction in the system
        System.out.println("Points assigned to " + student.getUsername() + ": " + points + " for " + field + " - " + reason);
    }
}

class AwardPointSystem {
    private Map<String, Accounts> students;
    private Map<String, Teacher> teachers;

    public AwardPointSystem() {
        this.students = new HashMap<>();
        this.teachers = new HashMap<>();
    }

    public void addStudent(Accounts student) {
        students.put(student.getUsername(), student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getUsername(), teacher);
    }

    public Accounts getStudent(String username) {
        return students.get(username);
    }

    public Teacher getTeacher(String username) {
        return teachers.get(username);
    }
}

class AwardPointTrackingSystem {
    public static void main(String[] args) {
        AwardPointSystem awardPointSystem = new AwardPointSystem();

        // Load teacher credentials from file
        Accounts student = new File("src/Accounts.txt");
        Teacher teacher = new File("src/Teacher.txt");

        Scanner scanner = new Scanner(System.in);

        // Sample award point assignment
        System.out.println("Teacher Login");
        System.out.print("Username: ");
        String teacherUsername = scanner.nextLine();
        System.out.print("Password: ");
        String teacherPassword = scanner.nextLine();

        Teacher loggedInTeacher = awardPointSystem.getTeacher(teacherUsername);

        if (loggedInTeacher != null && loggedInTeacher.getPassword().equals(teacherPassword)) {
            System.out.println("Login successful!");

            System.out.println("Assign Points:");
            System.out.print("Student Username: ");
            String studentUsername = scanner.nextLine();
            Accounts selectedStudent = awardPointSystem.getStudent(studentUsername);

            if (selectedStudent != null) {
                System.out.print("Points (100 or 0): ");
                int points = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Field (Behaviours, Grades, Attendances, School Activities): ");
                String field = scanner.nextLine();

                System.out.print("Reason: ");
                String reason = scanner.nextLine();

                loggedInTeacher.assignPoints(selectedStudent, points, field, reason);
                System.out.println("Total Points for " + selectedStudent.getUsername() + ": " + selectedStudent.getTotalPoints());
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }

    private static void loadStudents(AwardPointSystem awardPointSystem, String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Accounts student = new Accounts(parts[0], parts[1]);
                    awardPointSystem.addStudent(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Student file not found.");
        }
    }

    private static void loadTeachers(AwardPointSystem awardPointSystem, String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Teacher teacher = new Teacher(parts[0], parts[1]);
                    awardPointSystem.addTeacher(teacher);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Teacher file not found.");
        }
    }
}