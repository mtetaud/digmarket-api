package services.coinbase;

import models.trading.Candle;
import models.trading.Product;

import java.util.List;
import java.util.concurrent.CompletionStage;

public interface CoinbaseProxyService {

    CompletionStage<List<Product>> getProducts();
    CompletionStage<List<Candle>> getCandles(String pairId, String start, String end, String granularity);
}
