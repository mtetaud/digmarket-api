package services.coinbase;

import services.common.models.InputParameters;

import java.util.HashMap;

public class CoinbaseInputParameters extends InputParameters {

    public CoinbaseInputParameters() {
        this.host = "https://api.pro.coinbase.com";
        this.httpHeaders =
                new HashMap<String, String>() {{
                    put("CB-ACCESS-KEY", "ek1OyAzDbb5Nsq0tjyVIvxfOqdgqRx9jm6MMST4S7PLUIP6xi2OxbtwoPNCq7REgTzQmCw49WY0N+dwAY2Ifug==");
                }};
    }
}
