package cn.edu.shu.society.request;

/**
 * Created by jxxia on 2016/6/15 0015.
 */
public class AuthenticateRequest {

    private static final long serialVersionUID = -1L;

    //用户ID，可不填写
    private Long userID;

    //证件ID
    private String certifyID;

    //证件名称
    private String certifyName;

    //证件地址，可不填写
    private String certifyUrl;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getCertifyID() {
        return certifyID;
    }

    public void setCertifyID(String certifyID) {
        this.certifyID = certifyID;
    }

    public String getCertifyName() {
        return certifyName;
    }

    public void setCertifyName(String certifyName) {
        this.certifyName = certifyName;
    }

    public String getCertifyUrl() {
        return certifyUrl;
    }

    public void setCertifyUrl(String certifyUrl) {
        this.certifyUrl = certifyUrl;
    }
}
