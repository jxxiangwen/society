package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.service.VoteSubjectTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by jxxia on 2016/6/29 0029.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:/config/spring/spring-context.xml"})
public class VoteSubjectTypeServiceImplTest {

    @Autowired
    VoteSubjectTypeService voteSubjectTypeService;
    @Autowired
    MessageService messageService;

    @Test
    public void selectByPage() throws Exception {
        System.out.println(voteSubjectTypeService.selectByPage(1,1));
    }

    @Test
    public void testMessageService() throws Exception {
        messageService.findByMsgId(1,2,1L);
    }

}