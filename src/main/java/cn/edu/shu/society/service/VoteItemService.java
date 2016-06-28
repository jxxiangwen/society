package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteItemDTO record);
}