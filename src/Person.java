public class Person {
    private String ID;
    private String FirstName;
    private String LastName;
    private String Title;
    private int YearOfBirth;

    public Person(String ID, String firstName, String lastName, String title, int yearOfBirth) {
        this.ID = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Title = title;
        this.YearOfBirth = yearOfBirth;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getTitle() {
        return Title;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }
}
