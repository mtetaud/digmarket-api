import com.google.inject.AbstractModule;
import services.coinbase.CoinbaseProxyService;
import services.coinbase.impl.CoinbaseProxyServiceImpl;

public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(CoinbaseProxyService.class).to(CoinbaseProxyServiceImpl.class);
    }
}
