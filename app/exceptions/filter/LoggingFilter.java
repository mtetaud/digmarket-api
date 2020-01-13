package exceptions.filter;

import akka.stream.Materializer;
import exceptions.HttpException;
import org.slf4j.MDC;
import play.Logger;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class LoggingFilter extends CustomFilter {

    public static final Logger.ALogger logger = Logger.of(LoggingFilter.class);

    @Inject
    public LoggingFilter(Materializer mat) {
        super(mat);
    }

    @Override
    protected CompletionStage<Result> doApply(Function<Http.RequestHeader, CompletionStage<Result>> function, Http.RequestHeader requestHeader) {

        long startTime = System.currentTimeMillis();
        final Map<String, String> mdc = MDC.getCopyOfContextMap();

        try {
            return function.apply(requestHeader).thenApplyAsync(result -> {
                long requestTime = computeRequestTime(startTime);

                if (mdc != null) {
                    MDC.setContextMap(mdc);
                }

                return result.withHeader("Request-Time", "" + Long.toString(requestTime));
            });
        } catch (HttpException e) {
            long requestTime = computeRequestTime(startTime);

            if (mdc != null) {
                MDC.setContextMap(mdc);
            }
            logger.error("{} {} took {}ms and returned {}; {}", requestHeader.method(), requestHeader.uri(), requestTime, e.getType().getHttpStatus(), e.getMessage());
            throw e;
        } catch (Exception e) {
            long requestTime = computeRequestTime(startTime);

            if (mdc != null) {
                MDC.setContextMap(mdc);
            }
            logger.error("{} {} took {}ms and returned {}; {}", requestHeader.method(), requestHeader.uri(), requestTime, Http.Status.INTERNAL_SERVER_ERROR, e.getMessage());
            throw e;
        }

    }

    private long computeRequestTime(long startTime) {
        long endTime = System.currentTimeMillis();
        long requestTime = endTime - startTime;
        return requestTime;
    }
}
