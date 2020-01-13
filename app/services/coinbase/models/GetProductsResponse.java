package services.coinbase.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import models.trading.Product;

import java.util.List;

public class GetProductsResponse {

    @JsonProperty("data")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
