import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;

        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental rental : rentals) {

            double thisAmount = rental.getAmountFor();
            totalAmount += thisAmount;

            int currentRentalRenterPoints = rental.getCurrentRentalRenterPoints();
            totalFrequentRenterPoints += currentRentalRenterPoints;

            // show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");

        }
        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(totalFrequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}