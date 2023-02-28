public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    double getAmountFor() {
        return movie.priceCode.amountFor(this.daysRented);
    }

    int getCurrentRentalRenterPoints() {
        return movie.priceCode.renterPointsFor(this.daysRented);
    }

}
