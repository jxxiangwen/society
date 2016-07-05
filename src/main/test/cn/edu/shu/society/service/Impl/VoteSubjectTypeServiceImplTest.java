package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import cn.edu.shu.society.service.VoteSubjectService;
import cn.edu.shu.society.service.VoteSubjectTypeService;
import cn.edu.shu.society.service.VoteTopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

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
    VoteTopicService voteTopicService;

    @Autowired
    VoteSubjectService voteSubjectService;

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

}