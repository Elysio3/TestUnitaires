import pricecode.RegularPriceCode;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

    Customer aCustomer = new Customer("BILL", new ArrayList<>());

        aCustomer.addRental(new Rental(new Movie("Back To The Future", new RegularPriceCode()), 3));
        System.out.println(aCustomer.statement());
        System.out.println(aCustomer.statementHTML());

    }
}
