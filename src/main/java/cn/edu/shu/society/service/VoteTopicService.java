package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteResultOutDTO;
import cn.edu.shu.society.dto.VoteTopicDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VoteTopicService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteTopicDTO record);

    /**
     * @param id
     * @return
     */
    VoteTopicDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteTopicDTO> selectAll();

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<VoteTopicDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteTopicDTO record);

    /**
     * @param voteTypeId
     * @return
     */
    Long countByVoteTypeId(Long voteTypeId);

    /**
     * @param voteTypeId
     * @return
     */
    List<VoteTopicDTO> selectAllByVoteTypeId(Long voteTypeId);

    /**
     * @param voteTypeId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<VoteTopicDTO> selectByVoteTypeIdAndPage(Long voteTypeId, int pageNum, int pageSize);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<VoteTopicDTO> selectAllByPage(int pageNum, int pageSize);

    /**
     *
     * @param voteTopicId
     * @return
     */
    List<VoteResultOutDTO> exportTopicResult(Long voteTopicId);

    /**
     *
     * @param id
     * @return
     */
    VoteTopicDTO selectListByPrimaryKey(Long id);
}