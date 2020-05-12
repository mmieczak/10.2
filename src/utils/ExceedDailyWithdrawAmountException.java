package utils;

public class ExceedDailyWithdrawAmountException extends RuntimeException {
    public ExceedDailyWithdrawAmountException(String s) {
        super(s);
    }
}
