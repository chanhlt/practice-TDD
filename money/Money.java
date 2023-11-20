package money;

public class Money {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                && this.currency.equals(money.currency);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
