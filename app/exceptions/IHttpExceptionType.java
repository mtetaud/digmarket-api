package exceptions;

public interface IHttpExceptionType {
    int getHttpStatus();

    String getDefaultMessage();
}
