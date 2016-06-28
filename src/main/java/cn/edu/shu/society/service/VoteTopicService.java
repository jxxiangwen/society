package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteTopicDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteTopicDTO record);
}