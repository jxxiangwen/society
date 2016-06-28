package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteTypeService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteTypeDTO record);

    /**
     * @param id
     * @return
     */
    VoteTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteTypeDTO> selectAll();

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteTypeDTO record);
}