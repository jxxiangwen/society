package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteSubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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