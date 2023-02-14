import javax.swing.*;
import java.io.File;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        String fileName = "";
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No file selected");
            System.exit(0);
        }
        File file = new File(fileName);
        try {
            java.util.Scanner input = new java.util.Scanner(file);
            String header = String.format("%-10s%-15s%-15s%-8s%-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.print(header);
            String row = null;
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] parts = line.split(", ");
                Person person = new Person(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                row = String.format("%-10s%-15s%-15s%-8s%-5d%n", person.getID(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYearOfBirth());
                System.out.print(row);
            }
            input.close();
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}
