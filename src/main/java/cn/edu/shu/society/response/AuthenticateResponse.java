package cn.edu.shu.society.response;

public class AuthenticateResponse extends ResultResponse {

    //是否验证通过
    private boolean isPassed;

    //记录在用户认证表记录id
    private Long userViolationID;

    public AuthenticateResponse() {
    }

    public AuthenticateResponse(boolean isPassed, Long userViolationID) {
        this.isPassed = isPassed;
        this.userViolationID = userViolationID;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public Long getUserViolationID() {
        return userViolationID;
    }

    public void setUserViolationID(Long userViolationID) {
        this.userViolationID = userViolationID;
    }
}
