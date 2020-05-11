import java.util.Scanner;

public class Utilities {

    public static String[] collectPersonDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First name: ");
        String name = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Age: ");
        String age = scanner.nextLine();
        System.out.print("PESEL: ");
        String pesel = scanner.nextLine();
        scanner.close();

        return new String[]{name, lastName, age, pesel};
    }

    public static Person registerPerson(String[] personDetails) {
        Person person = null;
        try {
            return new Person(personDetails[0], personDetails[1], Integer.parseInt(personDetails[2]), Long.parseLong(personDetails[3]));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}


