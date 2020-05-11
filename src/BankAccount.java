public class BankAccount implements AccountOperations {
    public static final int MAXIMUM_WITHDRAW_AMOUNT = 1000;
    private final Person person;
    private double totalCash;


    public BankAccount(Person person, double totalCash) {
        this(person);
        this.totalCash = totalCash;
    }

    public BankAccount(Person person) {
        if (person == null) throw new NullPointerException("Unable to create account without valid Person details");
        this.person = person;
        this.totalCash = 0;
    }

    @Override
    public void deposit(double amount) {
        totalCash += amount;
    }

    @Override
    public void withdraw(double amount) throws ExceedDailyWithdrawAmountException,NotSUfficientMoneyException {
        if (amount > totalCash)
            throw new NotSUfficientMoneyException("There is not enought money on your account");
        else if (amount <= MAXIMUM_WITHDRAW_AMOUNT)
            totalCash -= amount;
        else
            throw new ExceedDailyWithdrawAmountException("You exceeded your daily limit that is set to " + MAXIMUM_WITHDRAW_AMOUNT);
    }

    public double getTotalCash() {
        return totalCash;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "person=" + person +
                ", totalCash=" + totalCash +
                '}';
    }
}
