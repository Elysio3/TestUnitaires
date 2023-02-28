package pricecode;

public class ChildrensPriceCode extends PriceCode {

    public double amountFor(int daysRented) {
        double thisAmount = 1.5;

        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    @Override
    public int renterPointsFor(int theDaysRented) {
        return 1;
    }
}
