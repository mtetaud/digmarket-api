package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;
import play.mvc.*;
import services.coinbase.CoinbaseProxyService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class CoinbaseController extends Controller {

    private static final Logger.ALogger LOGGER = Logger.of(CoinbaseController.class);

    @Inject
    CoinbaseProxyService coinbaseProxyService;

    public CompletionStage<Result> products() {
        LOGGER.info("enter products");
        ObjectMapper objectMapper = new ObjectMapper();
        return coinbaseProxyService.getProducts().thenApply(
                products -> {
                    try {
                        return ok(objectMapper.writeValueAsString(products))
                                .as(Http.MimeTypes.JSON);
                    } catch (Exception e) {
                        return internalServerError();
                    }
                }
        );
    }


    public CompletionStage<Result> candles(String pairId, String start, String end, String granularity) {
        return coinbaseProxyService.getCandles(pairId, start, end, granularity).thenApply(
                candles -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        return ok(objectMapper.writeValueAsString(candles)).as(Http.MimeTypes.JSON);
                    } catch (Exception e) {
                        return internalServerError();
                    }
                }
        );
    }

}
