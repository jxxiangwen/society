package cn.edu.shu.society.service;

import cn.edu.shu.society.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by jxxia on 2016/4/12 0012.
 */
public interface UserService {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户查询
     *
     * @param map
     * @return
     */
    List<User> find(Map<String, Object> map);

    /**
     * 获取总记录数
     *
     * @param map
     * @return
     */
    Long getTotal(Map<String, Object> map);

    /**
     * 修改用户
     *
     * @param user
     * @return影响的记录数
     */
    int update(User user);

    /**
     * 添加用户
     *
     * @param user
     * @return影响的记录数
     */
    int add(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int delete(Integer id);
}
