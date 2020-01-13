package models.trading;

public class Product {

    public String id;
    public String base_currency;
    public String quote_currency;
    public String base_min_size;
    public String base_max_size;
    public String quote_increment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBase_currency() {
        return base_currency;
    }

    public void setBase_currency(String base_currency) {
        this.base_currency = base_currency;
    }

    public String getQuote_currency() {
        return quote_currency;
    }

    public void setQuote_currency(String quote_currency) {
        this.quote_currency = quote_currency;
    }

    public String getBase_min_size() {
        return base_min_size;
    }

    public void setBase_min_size(String base_min_size) {
        this.base_min_size = base_min_size;
    }

    public String getBase_max_size() {
        return base_max_size;
    }

    public void setBase_max_size(String base_max_size) {
        this.base_max_size = base_max_size;
    }

    public String getQuote_increment() {
        return quote_increment;
    }

    public void setQuote_increment(String quote_increment) {
        this.quote_increment = quote_increment;
    }
}
