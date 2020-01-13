package services.coinbase;

import play.libs.ws.WSClient;
import services.coinbase.models.GetCandlesParameters;
import services.coinbase.models.GetCandlesResponse;
import services.coinbase.models.GetProductsParameters;
import services.coinbase.models.GetProductsResponse;
import services.common.RemoteService;

import javax.inject.Inject;

public class GetCandlesService extends RemoteService<GetCandlesResponse, GetCandlesParameters> {

    @Inject
    public GetCandlesService(WSClient wsClient){
        super(wsClient);
    }

}
