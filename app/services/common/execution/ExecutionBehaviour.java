package services.common.execution;

public interface ExecutionBehaviour {

    public static final DefaultExecutionBehaviour DEFAULT = DefaultExecutionBehaviour.getInstance();

    public static final AddPayloadExecutionBehaviour WITH_PAYLOAD = AddPayloadExecutionBehaviour.getInstance();

    public static final DisableCacheExecutionBehaviour DISABLE_CACHE = DisableCacheExecutionBehaviour.getInstance();

    public static final DisableErrorHandlerExecutionBehaviour DISABLE_ERROR_HANDLER = DisableErrorHandlerExecutionBehaviour.getInstance();

}
