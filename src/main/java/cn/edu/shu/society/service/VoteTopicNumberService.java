package cn.edu.shu.society.service;

import cn.edu.shu.society.entity.VoteTopicNumber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteTopicNumberService {

    /**
     *
     * @param record
     * @return
     */
    int insert(VoteTopicNumber record);

    /**
     *
     * @param voteTopicId
     * @return
     */
    Long selectByVoteTopicId(Long voteTopicId);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteTopicNumber record);
}