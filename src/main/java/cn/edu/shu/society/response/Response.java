/**
 * Created with IntelliJ IDEA.
 * UserDTO: walker
 * Date: 15/8/5
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */

package cn.edu.shu.society.response;


import cn.edu.shu.society.enums.ClientError;

public abstract class Response {

    private String errorMsg = "";

    private int result = ClientError.SUCCESS.getCode();

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
