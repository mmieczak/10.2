public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final long pesel;

    public Person(String firstName, String lastName, int age, long pesel) {
        if (firstName == null || lastName == null)
            throw new IllegalArgumentException("First & second name cannot be null");
        else if (firstName.length() < 3 || lastName.length() < 3)
            throw new IllegalArgumentException("First or second name are less then 2 characters");
        else {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        if (age < 1) throw new RuntimeException("Incorrect age");
        else
            this.age = age;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", pesel=" + pesel +
                '}';
    }
}
