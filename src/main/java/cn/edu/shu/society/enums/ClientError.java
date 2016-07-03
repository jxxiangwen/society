/**
 * Created with IntelliJ IDEA.
 * UserDTO: walker
 * Date: 15/8/5
 * Time: 23:0
 * To change this template use File | Settings | File Templates.
 */

package cn.edu.shu.society.enums;

public enum ClientError {
    SUCCESS(1, "成功"),

    SYSTEM_WRONG(-200, "系统繁忙，请稍后重试"),
    OBJECT_NOT_FOUND(-201, "未找到请求的数据"),
    BAD_REQUEST(-203, "无效的请求"),
    UPLOAD_FILE_ERROR(-204, "文件上传错误"),
    FILE_PATH_ERROR(-205, "文件路径错误"),
    FILE_SIZE_EXCEED_ERROR(-206, "文件超出太大，超出上传限制"),

    USER_NOT_LOGIN(-1000, "用户未登录"),
    FORBIDDEN(403, "权限不足"),;

    private int code;

    private String msg;

    ClientError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
