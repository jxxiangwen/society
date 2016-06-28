package cn.edu.shu.society.enums;

/**
 * Created by jxxia on 2016/6/28 0028.
 */
public enum LoginEnums {
    LOGIN_HOME("/WEB-INF/jsp/login.jsp"),
    LAST_PAGE("lastPage"),
    REDIRECT_HOME("/");
    private String msg;

    private LoginEnums(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
