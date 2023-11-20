package money;

public class Sum implements Expression {
    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.addend = addend;
        this.augend = augend;
    }

    public Money reduce(String to) {
        int amount = this.augend.amount + this.addend.amount;
        return new Money(amount, to);
    }

}
