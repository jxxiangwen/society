package cn.edu.shu.society.dto;

/**
 * Created by jxxia on 2016/7/2 0002.
 */
public class UserDTO {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String password;

    private Boolean isAdmin;

    private Integer AdminRoleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getAdminRoleId() {
        return AdminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        AdminRoleId = adminRoleId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", AdminRoleId=" + AdminRoleId +
                '}';
    }
}
