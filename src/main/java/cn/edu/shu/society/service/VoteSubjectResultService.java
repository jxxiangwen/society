package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteSubjectResultDTO;
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
     *
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
     *
     * @param voteSubjectId
     * @param userId
     * @return
     */
    List<VoteSubjectResultDTO> selectBySubjectIdAndUserId(Long voteSubjectId,Long userId);

    /**
     *
     * @param voteSubjectId
     * @return
     */
    List<VoteSubjectResultDTO> selectBySubjectId(Long voteSubjectId);
}