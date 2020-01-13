package exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.helpers.MessageFormatter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(value = { "stackTrace", "suppressed", "cause", "localizedMessage" })
public class HttpException extends RuntimeException {

    private static final long serialVersionUID = -457844512569963254L;

    private final transient IHttpExceptionType type;

    public HttpException(IHttpExceptionType type, Object... args) {
        super(MessageFormatter.arrayFormat(type.getDefaultMessage(), args).getMessage());
        this.type = type;
    }

    public HttpException(String s, IHttpExceptionType type, Object... args) {
        super(MessageFormatter.arrayFormat(s, args).getMessage());
        this.type = type;
    }

    public HttpException(String s, Throwable throwable, IHttpExceptionType type, Object... args) {
        super(MessageFormatter.arrayFormat(s, args).getMessage(), throwable);
        this.type = type;
    }

    public HttpException(Throwable throwable, IHttpExceptionType type, Object... args) {
        super(MessageFormatter.arrayFormat(type.getDefaultMessage(), args).getMessage(), throwable);
        this.type = type;
    }

    public IHttpExceptionType getType() {
        return type;
    }
}
