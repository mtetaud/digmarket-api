package services.coinbase;

import play.libs.ws.WSClient;
import services.coinbase.models.GetProductsParameters;
import services.coinbase.models.GetProductsResponse;
import services.common.RemoteService;

import javax.inject.Inject;

public class GetProductsService extends RemoteService<GetProductsResponse, GetProductsParameters> {

    @Inject
    public GetProductsService(WSClient wsClient){
        super(wsClient);
    }

}
