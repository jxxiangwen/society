package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteResultMap;
import cn.edu.shu.society.dto.VoteSubjectResultDTO;
import cn.edu.shu.society.dto.VoteTopicDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VoteSubjectResultService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteSubjectResultDTO record);

    /**
     * @param id
     * @return
     */
    VoteSubjectResultDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteSubjectResultDTO> selectAll();

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<VoteSubjectResultDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteSubjectResultDTO record);

    /**
     * @param voteSubjectId
     * @param userId
     * @return
     */
    List<VoteSubjectResultDTO> selectBySubjectIdAndUserId(Long voteSubjectId, Long userId);

    /**
     * @param voteSubjectId
     * @return
     */
    List<VoteSubjectResultDTO> selectBySubjectId(Long voteSubjectId);

    /**
     * @param resultVoteItemId
     * @return
     */
    Long countVoteNumberByVoteItemId(Long resultVoteItemId);

    /**
     * @param userId
     * @return
     */
    Long isHaveVoted(Long userId);

    /**
     *
     * @param userId
     * @param id
     * @param voteResultMap
     * @return
     */
    boolean saveVoteResult(Long userId, Long id, VoteResultMap voteResultMap);

    /**
     *
     * @param list
     * @return
     */
    Long countVoteNumberByList(List<Long> list);

    /**
     *
     * @param voteTopicId
     * @return
     */
    public VoteTopicDTO getVoteResult(Long voteTopicId);
}