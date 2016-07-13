/*
package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import cn.edu.shu.society.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

*/
/**
 * Created by jxxia on 2016/6/29 0029.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:/config/spring/spring-context.xml"})
public class VoteSubjectTypeServiceImplTest {

    @Autowired
    VoteSubjectTypeService voteSubjectTypeService;

    @Autowired
    VoteTopicService voteTopicService;

    @Autowired
    VoteSubjectService voteSubjectService;

    @Autowired
    UserService userService;

    @Autowired
    AdminUserService adminUserService;

    @Test
    public void selectByPage() throws Exception {
//        System.out.println(voteSubjectTypeService.selectByPage(1, 1));
//        System.out.println(voteTopicService.selectByPage(1,1).getList().size());
        System.out.println(null == voteSubjectService.selectByPrimaryKey(1L));
    }

    @Test
    public void update() throws Exception {
        VoteSubjectTypeDTO voteSubjectTypeDTO = voteSubjectTypeService.selectByPrimaryKey(1L);
        voteSubjectTypeDTO.setId(5L);
        voteSubjectTypeDTO.setTypeName("test");
        System.out.println(voteSubjectTypeService.updateByPrimaryKey(voteSubjectTypeDTO));
    }

    @Test
    public void testLeftJoin() {
        System.out.println(voteTopicService.selectListByPrimaryKey(1L));
    }

    public String TimeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
        return date;
    }

    @Test
    public void testDate() {
//        TimeStamp2Date
        System.out.println(new Date(1468050504L * 1000));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(20160705154223L));
//        System.out.println(sdf.format(new java.sql.Date(20160705154223L)));
    }


    @Test
    public void testUser() {
        UserDTO userDTO = userService.selectByUserId(10000L);
        System.out.println(userDTO);
    }

}*/
