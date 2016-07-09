package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteTopicNumberDTO;
import cn.edu.shu.society.entity.VoteTopicNumber;
import cn.edu.shu.society.repository.VoteTopicNumberMapper;
import cn.edu.shu.society.service.VoteTopicNumberService;
import cn.edu.shu.society.util.BeanUtility;
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
    public int insert(VoteTopicNumberDTO record) {
        return voteTopicNumberMapper.insert(BeanUtility.beanCopy(record, VoteTopicNumber.class));
    }

    /**
     * @param voteTopicId
     * @return
     */
    public Long selectByVoteTopicId(Long voteTopicId) {
        return voteTopicNumberMapper.selectByVoteTopicId(voteTopicId);
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteTopicNumberDTO record) {
        return voteTopicNumberMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteTopicNumber.class));
    }

    @Override
    public VoteTopicNumberDTO selectObjectByVoteTopicId(Long voteTopicId) {
        return BeanUtility.beanCopy(voteTopicNumberMapper.selectObjectByVoteTopicId(voteTopicId), VoteTopicNumberDTO.class);
    }

    @Override
    public int addVoteNumber(VoteTopicNumberDTO record) {
        return voteTopicNumberMapper.addVoteNumber(BeanUtility.beanCopy(record, VoteTopicNumber.class));
    }
}