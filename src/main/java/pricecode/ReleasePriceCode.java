package pricecode;

public class ReleasePriceCode extends PriceCode {

    public double amountFor(int theDaysRented) {
        return theDaysRented * 3;
    }

    @Override
    public int renterPointsFor(int theDaysRented) {
        if (theDaysRented > 1)
            return 2;
        return 1;
    }
}
