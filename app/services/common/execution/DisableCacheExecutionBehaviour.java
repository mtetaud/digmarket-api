package services.common.execution;

/**
 * Disable cache for CacheableApicService
 */
public class DisableCacheExecutionBehaviour implements ExecutionBehaviour {

    private final static DisableCacheExecutionBehaviour instance = new DisableCacheExecutionBehaviour();

    private DisableCacheExecutionBehaviour() {

    }

    public static DisableCacheExecutionBehaviour getInstance() {
        return instance;
    }

}
