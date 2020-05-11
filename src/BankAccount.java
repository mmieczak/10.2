public class BankAccount implements AccountOperations {
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
    public void withdraw(double amount) {
        if (amount > totalCash)
            throw new IllegalArgumentException("There is not enought money on your account");
        else
            totalCash -= amount;
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
