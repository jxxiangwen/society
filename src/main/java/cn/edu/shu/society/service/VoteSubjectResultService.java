package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteSubjectResultDTO;

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
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteSubjectResultDTO record);
}