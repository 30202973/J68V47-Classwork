import java.io.*;

public class L11E2 {
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            do {
                line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            } while (line != null);
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e);
        }
    }
}
//