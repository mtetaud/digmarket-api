package exceptions.filter;

import akka.stream.Materializer;
import play.mvc.Filter;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public abstract class CustomFilter extends Filter {

	@Inject
	public CustomFilter(Materializer mat) {
		super(mat);
	}

	protected abstract CompletionStage<Result> doApply(Function<Http.RequestHeader, CompletionStage<Result>> function, Http.RequestHeader requestHeader);

	@Override
	public CompletionStage<Result> apply(Function<Http.RequestHeader, CompletionStage<Result>> next, Http.RequestHeader requestHeader) {
		return doApply(next, requestHeader);
	}

}
