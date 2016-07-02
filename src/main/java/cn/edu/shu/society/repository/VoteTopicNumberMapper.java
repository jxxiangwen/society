package cn.edu.shu.society.repository;

import cn.edu.shu.society.entity.VoteTopicNumber;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteTopicNumberMapper {

    int insert(VoteTopicNumber record);


    Long selectByVoteTopicId(Long voteTopicId);


    int updateByPrimaryKey(VoteTopicNumber record);
}