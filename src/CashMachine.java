public class CashMachine {

    public static void main(String[] args) {

        String[] personDetails = Utilities.collectPersonDetails();
        Person person = Utilities.registerPerson(personDetails);
        BankAccount bankAccount;

        try {
            bankAccount = CreateBankAccount(person, 3500);
            bankAccount.deposit(1300);
            showAccount(bankAccount);
            bankAccount.withdraw(1100);
            showAccount(bankAccount);
        } catch (NotSUfficientMoneyException | ExceedDailyWithdrawAmountException e) {
            e.printStackTrace();
        }
    }

    private static BankAccount CreateBankAccount(Person person, double startAmount) {
        return new BankAccount(person, startAmount);
    }

    private static void showAccount(BankAccount bankAccount) {
        System.out.println(bankAccount.toString());
    }
}
