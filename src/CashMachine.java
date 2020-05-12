import data.BankAccount;
import data.Person;
import utils.ExceedDailyWithdrawAmountException;
import utils.NotSUfficientMoneyException;
import utils.Utilities;

import java.util.Scanner;

public class CashMachine {

    public static void main(String[] args) {
        //Methods used for 10.2_part1
       /* String[] details = utils.Utilities.collectPersonDetails();
        if (utils.Utilities.validatePerson(details))
            utils.Utilities.registerPerson(details);*/

        BankAccount[] bankAccounts = new BankAccount[3];
        bankAccounts[0] = createBankAccount(Utilities.registerPerson(new String[]{"Mike", "Tyson", "60", "12313213213"}), 0);
        bankAccounts[1] = createBankAccount(Utilities.registerPerson(new String[]{"Bill", "Clinton", "65", "564645654654"}), 1000);
        bankAccounts[2] = createBankAccount(Utilities.registerPerson(new String[]{"Janusz", "Korwin", "76", "45654645645"}), 20000);

        //Run cashMachine usage loop
        runCashMachine(bankAccounts);

    }

    private static BankAccount createBankAccount(Person person, double startAmount) {
        return new BankAccount(person, startAmount);
    }

    private static String getMenuOption(String question, int minTreshold, int maxTreshold, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String testedInput = scanner.nextLine();
        if (Integer.parseInt(testedInput) >= minTreshold && Integer.parseInt(testedInput) <= maxTreshold) {
            return testedInput;
        } else {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void runCashMachine(BankAccount[] bankAccounts ){
        Scanner scanner = new Scanner(System.in);
        String accountIndex, operation, amount;
        do {
            try {
                accountIndex = getMenuOption("Choose account [1-"+bankAccounts.length+"]: ", 1, bankAccounts.length, "There is no such account.Correct value 1-" + bankAccounts.length);
                operation = getMenuOption("Choose Operation [1 - deposit, 2 - withdraw]:", 1, 2, "There is no such operation. Choose 1 for deposit or 2 for withdraw");
                if (Integer.parseInt(operation) == 2) {
                    amount = getMenuOption("Type amount you wish to withdraw:", 0, 1000, "Wrong value. Maximum daily limit for withdrawal operation is 1000");
                    bankAccounts[Integer.parseInt(accountIndex) - 1].withdraw(Double.parseDouble(amount));
                } else {
                    amount = getMenuOption("Type your deposit amount:", 0, 100000, "Wrong amount. You can deposit amount from 0 to 1 mln");
                    bankAccounts[Integer.parseInt(accountIndex) - 1].deposit(Double.parseDouble(amount));

                }
                System.out.println(bankAccounts[Integer.parseInt(accountIndex) - 1]);
                System.out.println("Do you wish to continue y/n:");
            } catch (IllegalArgumentException | ExceedDailyWithdrawAmountException | NotSUfficientMoneyException e) {
                e.printStackTrace();
                System.out.println("Do you wish to continue y/n:");

            }
        } while ((scanner.nextLine().equalsIgnoreCase("y")));
    }

}
