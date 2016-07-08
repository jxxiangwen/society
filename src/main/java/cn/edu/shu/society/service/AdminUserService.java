package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.AdminUserDTO;

import java.util.List;

public interface AdminUserService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    int insert(AdminUserDTO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    AdminUserDTO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    List<AdminUserDTO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Fri Jul 08 15:10:07 CST 2016
     */
    int updateByPrimaryKey(AdminUserDTO record);

    AdminUserDTO selectByUserId(Long userId);
}