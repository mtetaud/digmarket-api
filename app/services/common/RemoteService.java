package services.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.DefaultHttpExceptionType;
import exceptions.HttpException;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Http;
import services.common.models.InputParameters;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import play.Logger;
import java.util.concurrent.CompletionStage;


public class RemoteService<R extends Object, I extends InputParameters> {

    private WSClient ws;
    public RemoteService(WSClient ws) {
        this.ws = ws;
    }
    public static final Logger.ALogger LOGGER = Logger.of(RemoteService.class);

    public CompletionStage<R> execute(I inputParameters){
        return this.proxy(inputParameters).thenApply(wsResponse -> {
            ObjectMapper mapper = new ObjectMapper();
            Type type = getClass().getGenericSuperclass();
            Type t = ((ParameterizedType)type).getActualTypeArguments()[0];

            try{
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .setSerializationInclusion(JsonInclude.Include.NON_NULL);

                StringBuilder data = new StringBuilder();
                data.append("{\"data\": ");
                data.append(wsResponse.getBody());
                data.append("}");

                return (R) mapper.readValue(
                        data.toString(),
                        Class.forName( (t.getTypeName() ))
                );
            } catch(Exception e){
                LOGGER.info("");
                return null;
            }
        });
    }

//    public CompletionStage<R> execute(I inputParameters, final ExecutionBehaviour ... executionBehaviours){
//
//    };

    public CompletionStage<WSResponse> proxy(I inputParameters){

        try{
            WSRequest wsRequest = ws.url(inputParameters.getUrl());
            switch(inputParameters.httpMethod){
                case Http.HttpVerbs.GET :
                    return wsRequest.get();
                default:
                    throw new HttpException(DefaultHttpExceptionType.UNKNOWN_ERROR);
            }
        } catch(Exception e){

            throw new HttpException(DefaultHttpExceptionType.UNKNOWN_ERROR);
        }
    };

//    public CompletionStage<WSResponse> proxy(final ExecutionBehaviour ... executionBehaviours){
//
//    };
}
