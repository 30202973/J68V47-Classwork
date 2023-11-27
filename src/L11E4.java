import java.io.*;

public class L11E4 {

    public static void main(String[] args) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(getFileName("Enter the first file name: ")));
             BufferedReader reader2 = new BufferedReader(new FileReader(getFileName("Enter the second file name: ")))) {

            boolean areIdentical = compareFileContents(reader1, reader2);

            if (areIdentical) {
                System.out.println("The contents of the files are identical.");
            } else {
                System.out.println("The contents of the files are not identical.");
            }

        } catch (IOException e) {
            System.out.println("Error occurred while reading the files: " + e);
        }
    }

    private static String getFileName(String prompt) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        return reader.readLine();
    }

    private static boolean compareFileContents(BufferedReader reader1, BufferedReader reader2) throws IOException {
        String line1, line2;
        while ((line1 = reader1.readLine()) != null) {
            line2 = reader2.readLine();

            if (line2 == null) {
                return false;
            }

            if (!line1.equals(line2)) {
                return false;
            }
        }

        return reader2.readLine() == null;
    }
}