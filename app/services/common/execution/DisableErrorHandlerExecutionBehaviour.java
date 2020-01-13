package services.common.execution;

/**
 * Instead of thrown an exception, the errorHandler will return a null object
 */
public class DisableErrorHandlerExecutionBehaviour implements ExecutionBehaviour {

    private final static DisableErrorHandlerExecutionBehaviour instance = new DisableErrorHandlerExecutionBehaviour();

    private DisableErrorHandlerExecutionBehaviour() {

    }

    public static DisableErrorHandlerExecutionBehaviour getInstance() {
        return instance;
    }

}
