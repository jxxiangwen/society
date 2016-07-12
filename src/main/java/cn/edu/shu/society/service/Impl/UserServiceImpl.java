package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.entity.User;
import cn.edu.shu.society.repository.UserMapper;
import cn.edu.shu.society.service.UserService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jxxia on 2016/7/8 0008.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserDTO record) {
        return userMapper.insert(BeanUtility.beanCopy(record, User.class));
    }

    @Override
    public UserDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(userMapper.selectByPrimaryKey(id), UserDTO.class);
    }

    @Override
    public List<UserDTO> selectAll() {
        List<User> userList = userMapper.selectAll();
        Iterator<User> iterator = userList.iterator();
        List<UserDTO> userDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            userDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), UserDTO.class));
        }
        return userDTOLinkedList;
    }

    @Override
    public PageInfo<UserDTO> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "create_time desc");
        List<User> userList = userMapper.selectAll();
        PageInfo<User> page = new PageInfo(userList);
        Iterator<User> iterator = userList.iterator();
        List<UserDTO> userDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            userDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), UserDTO.class));
        }
        PageInfo<UserDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(userDTOLinkedList);
        return page1;
    }

    @Override
    public int updateByPrimaryKey(UserDTO record) {
        return userMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, User.class));
    }

    @Override
    public UserDTO selectByUserId(Long userId) {
        return BeanUtility.beanCopy(userMapper.selectByUserId(userId), UserDTO.class);
    }
}
