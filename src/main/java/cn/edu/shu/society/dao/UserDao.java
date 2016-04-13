package cn.edu.shu.society.dao;

import cn.edu.shu.society.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Dao接口
 * Created by jxxia on 2016/4/12 0012.
 */
@Component
@Repository(value="UserDao")
public interface UserDao {

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
     * @return用户集合
     */
    List<User> find(Map<String, Object> map);

    /**
     * 获取总记录数
     *
     * @param map
     * @return获取的total数
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
