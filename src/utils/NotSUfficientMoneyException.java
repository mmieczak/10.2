package utils;

public class NotSUfficientMoneyException extends RuntimeException {
    public NotSUfficientMoneyException(String s) {
        super(s);
    }
}
