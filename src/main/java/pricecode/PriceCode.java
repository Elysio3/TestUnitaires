package pricecode;

public abstract class PriceCode {

    public abstract double amountFor(int theDaysRented);

    public abstract int renterPointsFor(int theDaysRented);
}
