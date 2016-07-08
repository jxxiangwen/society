package cn.edu.shu.society.enums;

/**
 * Created by jxxia on 2016/6/28 0028.
 */
public enum LoginEnums {
    LOGIN_HOME_JSP("/WEB-INF/jsp/login.jsp"),
    LOGIN_HOME("login"),
    ADMIN_LOGIN_HOME_JSP("/WEB-INF/jsp/adminLogin.jsp"),
    ADMIN_LOGIN_HOME("adminLogin"),
    LAST_PAGE("lastPage"),
    REDIRECT_HOME("/");
    private String msg;

    LoginEnums(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
