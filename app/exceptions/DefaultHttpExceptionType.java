package exceptions;

import play.mvc.Http;

public enum DefaultHttpExceptionType implements IHttpExceptionType {
    UNKNOWN_ERROR(Http.Status.INTERNAL_SERVER_ERROR, "Unknown error {}");

    private final int httpStatus;
    private final String defaultMessage;

    DefaultHttpExceptionType(int httpStatus, String defaultMessage) {
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }
}
