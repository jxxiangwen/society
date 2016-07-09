package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteItemDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VoteItemService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteItemDTO record);

    /**
     * @param id
     * @return
     */
    VoteItemDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteItemDTO> selectAll();

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<VoteItemDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteItemDTO record);

    /**
     *
     * @param voteSubjectId
     * @return
     */
    List<Long> selectItemIdBySubject(Long voteSubjectId);
}