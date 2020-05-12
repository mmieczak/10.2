package utils;

import data.Person;

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

        return new String[]{name, lastName, age, pesel};
    }

    public static boolean validatePerson(String[] personDetails) {
        try {
            new Person(personDetails[0], personDetails[1], Integer.parseInt(personDetails[2]), Long.parseLong(personDetails[3]));
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    public static Person registerPerson(String[] personDetails) {
        return new Person(personDetails[0], personDetails[1], Integer.parseInt(personDetails[2]), Long.parseLong(personDetails[3]));
    }

}


