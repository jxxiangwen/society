package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.entity.VoteTopicNumber;
import cn.edu.shu.society.repository.VoteTopicNumberMapper;
import cn.edu.shu.society.service.VoteTopicNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteTopicNumberServiceImpl implements VoteTopicNumberService {

    @Autowired
    VoteTopicNumberMapper voteTopicNumberMapper;

    /**
     * @param record
     * @return
     */
    public int insert(VoteTopicNumber record) {
        return voteTopicNumberMapper.insert(record);
    }

    /**
     * @param voteTopicId
     * @return
     */
    public Long selectByVoteTopicId(Long voteTopicId){
        return voteTopicNumberMapper.selectByVoteTopicId(voteTopicId);
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteTopicNumber record){
        return voteTopicNumberMapper.updateByPrimaryKey(record);
    }
}