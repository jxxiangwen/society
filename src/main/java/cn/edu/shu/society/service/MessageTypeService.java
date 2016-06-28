package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.MessageTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageTypeService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(MessageTypeDTO record);

    /**
     * @param id
     * @return
     */
    MessageTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<MessageTypeDTO> selectAll();

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MessageTypeDTO record);
}