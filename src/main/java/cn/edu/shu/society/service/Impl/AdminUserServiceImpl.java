package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.AdminUserDTO;
import cn.edu.shu.society.entity.AdminUser;
import cn.edu.shu.society.entity.User;
import cn.edu.shu.society.repository.AdminUserMapper;
import cn.edu.shu.society.service.AdminUserService;
import cn.edu.shu.society.util.BeanUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jxxia on 2016/7/8 0008.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdminUserDTO record) {
        return adminUserMapper.insert(BeanUtility.beanCopy(record, AdminUser.class));
    }

    @Override
    public AdminUserDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(adminUserMapper.selectByPrimaryKey(id), AdminUserDTO.class);
    }

    @Override
    public List<AdminUserDTO> selectAll() {
        List<AdminUser> adminUserList = adminUserMapper.selectAll();
        Iterator<AdminUser> iterator = adminUserList.iterator();
        List<AdminUserDTO> adminUserDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            adminUserDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), AdminUserDTO.class));
        }
        return adminUserDTOLinkedList;
    }

    @Override
    public int updateByPrimaryKey(AdminUserDTO record) {
        return adminUserMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, AdminUser.class));
    }

    @Override
    public AdminUserDTO selectByUserId(Long userId) {
        return BeanUtility.beanCopy(adminUserMapper.selectByUserId(userId), AdminUserDTO.class);
    }
}
