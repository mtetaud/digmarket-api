package exceptions;

import play.Environment;
import play.Logger;
import play.api.OptionalSourceMapper;
import play.api.UsefulException;
import play.api.routing.Router;
import play.http.DefaultHttpErrorHandler;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import com.typesafe.config.Config;
import play.mvc.Results;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ErrorHandler extends DefaultHttpErrorHandler {

    private static final Logger.ALogger logger = Logger.of(ErrorHandler.class);

    @Inject
    public ErrorHandler(Config config, Environment environment,
                        OptionalSourceMapper sourceMapper, Provider<Router> routes) {
        super(config, environment, sourceMapper, routes);
    }


    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        final HttpException httpException;
        if(exception instanceof HttpException){
            httpException = (HttpException) exception;
        } else if (exception.getCause() instanceof HttpException){
            httpException = (HttpException) exception.getCause();
        } else {
            return super.onServerError(request, exception);
        }

        if(httpException.getType().getHttpStatus() >= 500){
            logger.error("HTTP 500 error handled by custom ErrorHandler", exception);
        } else if (logger.isDebugEnabled()) {
            logger.debug("Handled by custom ErrorHandler", exception);
        } else {
            logger.info("Handled by custom ErrorHandler : {}", exception.getMessage());
        }

        return CompletableFuture.completedFuture(Results.status(httpException.getType().getHttpStatus(), Json.toJson(httpException)));
    }

    @Override
    protected CompletionStage<Result> onDevServerError(Http.RequestHeader request, UsefulException exception) {
        return super.onProdServerError(request, exception);
    }
}
