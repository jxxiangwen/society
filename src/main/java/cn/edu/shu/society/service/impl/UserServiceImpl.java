package cn.edu.shu.society.service.impl;

import cn.edu.shu.society.dao.UserDao;
import cn.edu.shu.society.domain.User;
import cn.edu.shu.society.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Service实现
 * Created by jxxia on 2016/4/12 0012.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User findById(int id) {
        return userDao.findById(id);
    }

    public User login(User user) {
        return userDao.login(user);
    }

    public List<User> find(Map<String, Object> map) {
        return userDao.find(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return userDao.getTotal(map);
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public int add(User user) {
        return userDao.add(user);
    }

    public int delete(Integer id) {
        return userDao.delete(id);
    }
}
