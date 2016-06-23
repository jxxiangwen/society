package cn.edu.shu.society.exception;

import ocean.exception.ExceptionInfo;
import ocean.exception.ExceptionInfoGetter;
import org.springframework.core.NestedRuntimeException;

/**
 * Created by chewenjie on 2015/8/17.
 */
public class AppException extends NestedRuntimeException implements ExceptionInfoGetter {

    private static final long serialVersionUID = 1L;

    private String message;

    private Integer code;

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Integer code) {
        super(message);
        this.code = code;
        this.message=message;
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInfo getInfo() {
        ExceptionInfo exceptionInfo = new ExceptionInfo(this.code, this.message);
        return exceptionInfo;
    }
}
