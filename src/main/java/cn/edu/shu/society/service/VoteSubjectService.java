package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteSubjectDTO;

import java.util.List;

public interface VoteSubjectService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteSubjectDTO record);

    /**
     * @param id
     * @return
     */
    VoteSubjectDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteSubjectDTO> selectAll();

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteSubjectDTO record);
}