package services.common.execution;

/**
 * Add payload of the WsResponse in the error response. <br>
 * Use with caution, some private information could become available for customers
 */
public class AddPayloadExecutionBehaviour implements ExecutionBehaviour {

    private final static AddPayloadExecutionBehaviour instance = new AddPayloadExecutionBehaviour();

    private AddPayloadExecutionBehaviour() {

    }

    public static AddPayloadExecutionBehaviour getInstance() {
        return instance;
    }

}
