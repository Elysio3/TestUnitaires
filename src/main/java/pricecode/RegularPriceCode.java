package pricecode;

public class RegularPriceCode extends PriceCode {

    public double amountFor(int daysRented) {
        double thisAmount = 2;

        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }

    @Override
    public int renterPointsFor(int theDaysRented) {
        return 1;
    }
}