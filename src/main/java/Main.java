import java.util.ArrayList;
import java.util.Vector;

public class Main {


    public static void main(String[] args) {

    Customer aCustomer = new Customer("BILL", new ArrayList<>());

        aCustomer.addRental(new Rental(new Movie("Back To The Future", Movie.REGULAR), 3));
        System.out.println(aCustomer.statement());

    }
}
