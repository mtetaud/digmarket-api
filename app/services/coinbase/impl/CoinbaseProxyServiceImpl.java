package services.coinbase.impl;

import models.trading.Candle;
import models.trading.Product;
import services.coinbase.CoinbaseProxyService;
import services.coinbase.GetCandlesService;
import services.coinbase.GetProductsService;
import services.coinbase.models.GetCandlesParameters;
import services.coinbase.models.GetProductsParameters;
import services.coinbase.models.GetProductsResponse;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class CoinbaseProxyServiceImpl implements CoinbaseProxyService {

    private GetProductsService getProductsService;
    private GetCandlesService getCandlesService;

    @Inject
    public CoinbaseProxyServiceImpl(GetProductsService getProductsService){
        this.getProductsService = getProductsService;
    }

    public CompletionStage<List<Product>> getProducts(){
        GetProductsParameters getProductsParameters = new GetProductsParameters();
        return getProductsService.execute(getProductsParameters).thenApply(
                getProductsResponse -> {
                    return getProductsResponse.getProducts();
                }
        );
    }

    @Override
    public CompletionStage<List<Candle>> getCandles(String pairId, String start, String end, String granularity) {
        GetCandlesParameters getCandlesParameters = new GetCandlesParameters();
        getCandlesParameters.setQueryParams(new HashMap<String, String>() {{
            put("start", start);
            put("end", end);
            put("granularity", granularity);
        }});
        getCandlesParameters.setPathParams(Arrays.asList(pairId));

        return getCandlesService.execute(getCandlesParameters).thenApply(
                getCandlesResponse -> {
                    return getCandlesResponse.getCandles();
                }
        );
    }


}
