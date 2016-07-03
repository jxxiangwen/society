package cn.edu.shu.society.handler;

import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.enums.DefaultPage;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.response.ResultResponse;
import ocean.exception.AuthException;
import ocean.exception.ExceptionInfo;
import ocean.exception.ExceptionInfoGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 统一异常解析。 负责拦截所有Rest抛出的异常。
 */
@ControllerAdvice
public class ExceptionAdvice {
    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResultResponse handleAuthException(AuthException ex) {
        ResultResponse exceptionData = new ResultResponse();
        exceptionData.setErrorMsg(ex.getContent());
        exceptionData.setResult(HttpStatus.UNAUTHORIZED.value());
        logger.error("exception code:" + exceptionData.getResult() + ",exception message:" + exceptionData.getErrorMsg(),
                ex);

        return exceptionData;
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResultResponse handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        ResultResponse exceptionData = new ResultResponse();
        exceptionData.setErrorMsg(ClientError.FILE_SIZE_EXCEED_ERROR.getMsg());
        exceptionData.setResult(ClientError.FILE_SIZE_EXCEED_ERROR.getCode());
        logger.error("exception code:" + exceptionData.getResult() + ",exception message:" + exceptionData.getErrorMsg(),
                ex);

        return exceptionData;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResultResponse handleException(Exception ex) {
        ResultResponse exceptionData = null;
        Throwable exception = getHasInfoException(ex);
        if (exception == null) {
            exceptionData = new ResultResponse();
            exceptionData.setResult(ClientError.SYSTEM_WRONG.getCode());
            exceptionData.setErrorMsg(ClientError.SYSTEM_WRONG.getMsg());
        } else {
            ExceptionInfo exceptionInfo = ((ExceptionInfoGetter) exception).getInfo();
            String message = exceptionInfo.getMessage();
            Integer code = exceptionInfo.getCode();

            if (StringUtils.isEmpty(message)) {
                message = ClientError.SYSTEM_WRONG.getMsg();
            }
            exceptionData = new ResultResponse();
            exceptionData.setResult(code);
            exceptionData.setErrorMsg(message);
        }

        logger.error("exception code:" + exceptionData.getResult() + ",exception message:" + exceptionData.getErrorMsg(),
                ex);

        return exceptionData;
    }

    @ExceptionHandler(AppViewException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView handleAppException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView(DefaultPage.ERROR_404_PAGE.getPage());

        ResultResponse exceptionData = null;
        Throwable exception = getHasInfoException(ex);
        if (exception == null) {
            modelAndView.addObject("errorMessage", ClientError.SYSTEM_WRONG.getMsg());
        } else {
            ExceptionInfo exceptionInfo = ((ExceptionInfoGetter) exception).getInfo();
            String message = exceptionInfo.getMessage();
            if (StringUtils.isEmpty(message)) {
                modelAndView.addObject("errorMessage", ClientError.SYSTEM_WRONG.getMsg());
            }
            modelAndView.addObject("errorMessage", message);
        }

        logger.error("exception code:" + exceptionData.getResult() + ",exception message:" + exceptionData.getErrorMsg(),
                ex);

        return new ModelAndView();
    }

    private Throwable getHasInfoException(Throwable throwable) {
        Throwable exception = null;

        if (throwable instanceof ExceptionInfoGetter) {
            exception = (Exception) throwable;
        }

        Throwable childThrowable = null;
        if (throwable instanceof UndeclaredThrowableException) {
            childThrowable = ((UndeclaredThrowableException) throwable).getUndeclaredThrowable();
        } else {
            childThrowable = throwable.getCause();
        }
        if (childThrowable != null) {
            Throwable childExp = getHasInfoException(childThrowable);
            if (childExp != null) {
                return childExp;
            }
        }

        return exception;
    }
}
