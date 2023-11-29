import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L12E2 {

    public static ArrayList<Student> loadFile(String filename) {
        List<String> studentDetails;
        ArrayList<Student> thisClass = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            while (line != null) {
                studentDetails = Arrays.asList(line.split(","));
                Student newStudent = new Student();
                newStudent.id = Integer.parseInt(studentDetails.get(0));
                newStudent.firstName = studentDetails.get(1);
                newStudent.surname = studentDetails.get(2);
                newStudent.present = Boolean.parseBoolean(studentDetails.get(3));
                thisClass.add(newStudent);
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred reading file: " + e.toString());
        }
        return thisClass;
    }

    public static String attendance(boolean studentIsHere) {
        // return X if student is present, O if student is not present
        // ...
        if (studentIsHere == true) {
            return "x";
        }
        else {
            return "o";
        }
    }



    public static void displayStudent(Student thisStudent) {
        // note the slight change to this procedure
        System.out.format("%s (%d) %s %s %n", attendance(thisStudent.present), thisStudent.id, thisStudent.firstName, thisStudent.surname);
    }

    public static void main(String[] args) {
        // load file contents into an array of student objects
        ArrayList<Student> thisClass = loadFile("src/students.txt");
        // loop for all objects and show details
        for (int i = 0; i < thisClass.size(); i++) {
            Student thisStudent = thisClass.get(i);
            // show details for this student
            // ...
            displayStudent(thisStudent);
        }
    }
}
