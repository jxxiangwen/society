package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.entity.MessageType;
import cn.edu.shu.society.service.MessageTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageTypeServiceImpl implements MessageTypeService{
    private static Logger logger = LoggerFactory.getLogger(MessageTypeServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(MessageTypeDTO record);

    /**
     * @param id
     * @return
     */
    public MessageTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<MessageTypeDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(MessageTypeDTO record);
}