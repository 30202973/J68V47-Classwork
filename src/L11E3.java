import java.io.*;

public class L11E3 {

    public static void main(String[] args) {
        String filePath = "output2.txt";

        try {
            write(filePath);
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
        try {
            int sum = sum(filePath);
            System.out.println("The total sum of the numbers in the file is: " + sum);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid data in the file.");
        }
    }

    private static void write(String filePath) throws IOException {
        try (PrintWriter out = new PrintWriter( new FileWriter(filePath))) {
            for (int i = 1; i <= 10; i++) {
                out.println(i);

            }
        }
    }
    private static int sum(String filePath) throws IOException {

        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            while ((line = in.readLine()) != null) {
                sum += Integer.parseInt(line.trim());
            }

            return sum;
        }
    }
}
//