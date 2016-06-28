package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteSubjectTypeService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteSubjectTypeDTO record);

    /**
     * @param id
     * @return
     */
    VoteSubjectTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteSubjectTypeDTO> selectAll();

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteSubjectTypeDTO record);
}