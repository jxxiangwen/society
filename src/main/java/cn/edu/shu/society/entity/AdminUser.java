package cn.edu.shu.society.entity;

public class AdminUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.id
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.user_id
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.user_name
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.password
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.college
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private String college;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.major
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private String major;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.create_time
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private Long createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.update_time
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    private Long updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.id
     *
     * @return the value of admin_user.id
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.id
     *
     * @param id the value for admin_user.id
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.user_id
     *
     * @return the value of admin_user.user_id
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.user_id
     *
     * @param userId the value for admin_user.user_id
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.user_name
     *
     * @return the value of admin_user.user_name
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.user_name
     *
     * @param userName the value for admin_user.user_name
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.password
     *
     * @return the value of admin_user.password
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.password
     *
     * @param password the value for admin_user.password
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.college
     *
     * @return the value of admin_user.college
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public String getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.college
     *
     * @param college the value for admin_user.college
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.major
     *
     * @return the value of admin_user.major
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.major
     *
     * @param major the value for admin_user.major
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.create_time
     *
     * @return the value of admin_user.create_time
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.create_time
     *
     * @param createTime the value for admin_user.create_time
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.update_time
     *
     * @return the value of admin_user.update_time
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.update_time
     *
     * @param updateTime the value for admin_user.update_time
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}