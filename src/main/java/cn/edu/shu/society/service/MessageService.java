package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(MessageDTO record);

    /**
     * @param id
     * @return
     */
    MessageDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<MessageDTO> selectAll();

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MessageDTO record);
}