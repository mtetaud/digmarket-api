package exceptions.filter;

import com.google.common.collect.Lists;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Filters implements HttpFilters {

    protected final EssentialFilter loggingFilter;

    @Inject
    public Filters(LoggingFilter loggingFilter) {
        this.loggingFilter = loggingFilter;
    }

    @Override
    public List<EssentialFilter> getFilters() {
        List<EssentialFilter> essentialFilter = Lists.newArrayList(loggingFilter);
        return essentialFilter;
    }
}
