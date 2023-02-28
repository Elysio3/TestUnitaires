import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pricecode.ChildrensPriceCode;
import pricecode.RegularPriceCode;
import pricecode.ReleasePriceCode;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer aCustomer;

    @BeforeEach
    public void setUp() {
        aCustomer = new Customer("BILL", new ArrayList<>());
    }

    @Test
    public void
    should_rent_a_regular_film_for_5_days_for_6_point_5_dollars() {
        aCustomer.addRental(new Rental(new Movie("Back To The Future", new RegularPriceCode()), 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tBack To The Future\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void
    should_rent_a_children_film_for_5_days_for_15_dollars() {
        aCustomer.addRental(new Rental(new Movie("Toy Story", new ChildrensPriceCode()), 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tToy Story\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void
    should_rent_a_new_release_film_for_5_days_for_6_point_5_dollars() {
        aCustomer.addRental(new Rental(new Movie("Alien", new ReleasePriceCode()), 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tAlien\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points");
    }

    @Test
    public void
    should_rent_multiple_films() {
        aCustomer.addRental(new Rental(new Movie("Alien", new RegularPriceCode()), 5));
        aCustomer.addRental(new Rental(new Movie("Alien 2", new RegularPriceCode()), 5));
        aCustomer.addRental(new Rental(new Movie("Alien 3", new ReleasePriceCode()), 5));

        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tAlien\t6.5\n" +
                "\tAlien 2\t6.5\n" +
                "\tAlien 3\t15.0\n" +
                "Amount owed is 28.0\n" +
                "You earned 4 frequent renter points");
    }

    @Test
    public void
    should_change_price_code_of_a_movie() {
        Movie alien = new Movie("Alien", new ReleasePriceCode());
        alien.setPriceCode(new RegularPriceCode());
        aCustomer.addRental(new Rental(alien, 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tAlien\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");
    }
}
