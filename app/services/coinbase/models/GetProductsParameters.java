package services.coinbase.models;

import play.mvc.Http;
import services.coinbase.CoinbaseInputParameters;

public class GetProductsParameters extends CoinbaseInputParameters {

    public GetProductsParameters(){
        this.resourcePattern = "/products";
        this.httpMethod = Http.HttpVerbs.GET;
    }
}
