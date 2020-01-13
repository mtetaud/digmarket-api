package services.coinbase.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import models.trading.Candle;
import models.trading.Product;

import java.util.List;

public class GetCandlesResponse {

    @JsonProperty("data")
    private List<Candle> candles;

    public List<Candle> getCandles() {
        return candles;
    }

    public void setCandles(List<Candle> candles) {
        this.candles = candles;
    }
}
