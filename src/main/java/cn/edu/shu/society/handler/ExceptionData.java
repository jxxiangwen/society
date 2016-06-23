package cn.edu.shu.society.handler;

import java.io.Serializable;

public class ExceptionData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 异常编码
     */
    private Integer result;

    /**
     * 后台异常描述，正常不应该把后台异常描述反馈给前台用户
     */
    private String errorMsg;

    public ExceptionData() {
    }

    public ExceptionData(Integer result, String errorMsg) {
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
