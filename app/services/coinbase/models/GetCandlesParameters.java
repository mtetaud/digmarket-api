package services.coinbase.models;

import play.mvc.Http;
import services.coinbase.CoinbaseInputParameters;

public class GetCandlesParameters extends CoinbaseInputParameters {

    public GetCandlesParameters(){
        this.resourcePattern = "/products/#/candles";
        this.httpMethod = Http.HttpVerbs.GET;
    }
}
