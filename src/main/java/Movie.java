import pricecode.PriceCode;

public class Movie {

    private final String title;
    PriceCode priceCode;

    public Movie (String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

}
