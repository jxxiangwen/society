package cn.edu.shu.society.enums;

/**
 * Created by jxxia on 2016/6/28 0028.
 */
public enum AdminType {
    ADMIN("总管理员", 0),;
    private String roleDescription;
    private Integer roleId;

    AdminType(String roleDescription, Integer roleId) {
        this.roleDescription = roleDescription;
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public Integer getRoleId() {
        return roleId;
    }
}
