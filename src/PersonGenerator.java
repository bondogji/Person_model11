import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonGenerator {

    private static String generateFormattedString(Person person) {
        // format string like this: id, firstName, lastName, title, yearOfBirth
        return String.format("%s, %s, %s, %s, %d", person.getID(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYearOfBirth());
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        Scanner pipe = new Scanner(System.in);

        boolean keepGoing = true;
        while (keepGoing) {
            String id = SafeInput.getNonZeroLenString(pipe, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(pipe, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(pipe, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(pipe, "Enter Title");
            int yearOfBirth = SafeInput.getRangedInt(pipe, "Enter Year of Birth ", 0, 3000);
            people.add(new Person(id, firstName, lastName, title, yearOfBirth));
            keepGoing = SafeInput.getYNConfirm(pipe, "Do you want to enter another person?");
        }

        // create a file called PersonTestData.txt with one person per line


        File file = new File("PersonTestData.txt");
        try {
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            for (Person person : people) {
                // only add line feed if not last person
                if (people.indexOf(person) != people.size() - 1) {
                    output.println(generateFormattedString(person));
                } else {
                    output.print(generateFormattedString(person));
                }
            }
            output.close();
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("File not found");
        }



    }
}