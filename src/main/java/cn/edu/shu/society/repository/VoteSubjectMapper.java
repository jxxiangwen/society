package cn.edu.shu.society.repository;

import cn.edu.shu.society.entity.VoteSubject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteSubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_subject
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_subject
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    int insert(VoteSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_subject
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    VoteSubject selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_subject
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    List<VoteSubject> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_subject
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    List<VoteSubject> selectAllByVoteTopicId(Long VoteTopicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_subject
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    int updateByPrimaryKey(VoteSubject record);
}