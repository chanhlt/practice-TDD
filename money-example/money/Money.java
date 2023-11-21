package money;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        Money money = (Money) obj;
        return this.amount == money.amount
                && this.currency.equals(money.currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public int hashCode() {
        return this.amount;
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
