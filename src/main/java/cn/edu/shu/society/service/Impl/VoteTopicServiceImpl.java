package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.entity.VoteTopic;
import cn.edu.shu.society.repository.VoteTopicMapper;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VoteTopicServiceImpl implements VoteTopicService {
    private static Logger logger = LoggerFactory.getLogger(VoteTopicServiceImpl.class);

    @Autowired
    VoteTopicMapper voteTopicMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return voteTopicMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteTopicDTO record) {
        return voteTopicMapper.insert(BeanUtility.beanCopy(record, VoteTopic.class));
    }


    /**
     * @param id
     * @return
     */
    public VoteTopicDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteTopicMapper.selectByPrimaryKey(id), VoteTopicDTO.class);
    }


    /**
     * @return
     */
    public List<VoteTopicDTO> selectAll() {
        List<VoteTopic> voteTopicList = voteTopicMapper.selectAll();
        Iterator<VoteTopic> iterator = voteTopicList.iterator();
        List<VoteTopicDTO> voteTopicDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTopicDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTopicDTO.class));
        }
        return voteTopicDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteTopicDTO record) {
        return voteTopicMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteTopic.class));
    }
}