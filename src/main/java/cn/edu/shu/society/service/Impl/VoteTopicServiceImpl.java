package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.entity.VoteTopic;
import cn.edu.shu.society.service.VoteTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VoteTopicServiceImpl implements VoteTopicService{
    private static Logger logger = LoggerFactory.getLogger(VoteTopicServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(VoteTopicDTO record);

    /**
     * @param id
     * @return
     */
    public VoteTopicDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<VoteTopicDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteTopicDTO record);
}