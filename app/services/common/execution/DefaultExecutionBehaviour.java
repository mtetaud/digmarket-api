package services.common.execution;

public class DefaultExecutionBehaviour implements ExecutionBehaviour {

    private final static DefaultExecutionBehaviour instance = new DefaultExecutionBehaviour();

    private DefaultExecutionBehaviour() {

    }

    public static DefaultExecutionBehaviour getInstance() {
        return instance;
    }

}
