package cn.edu.shu.society.exception;

import ocean.exception.ExceptionInfo;
import ocean.exception.ExceptionInfoGetter;
import org.springframework.core.NestedRuntimeException;

/**
 * 用于view返回的错误
 * Created by chewenjie on 2015/8/17.
 */
public class AppViewException extends NestedRuntimeException implements ExceptionInfoGetter {

    private static final long serialVersionUID = 1L;

    private String message;

    private Integer code;

    public AppViewException(String message) {
        super(message);
    }

    public AppViewException(String message, Integer code) {
        super(message);
        this.code = code;
        this.message=message;
    }

    public AppViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInfo getInfo() {
        ExceptionInfo exceptionInfo = new ExceptionInfo(this.code, this.message);
        return exceptionInfo;
    }
}
