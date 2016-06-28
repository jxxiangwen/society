package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.repository.MessageMapper;
import cn.edu.shu.society.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    private static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    @Autowired
    MessageMapper messageMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(MessageDTO record) {
        return messageMapper.insert(record);
    }

    /**
     * @param id
     * @return
     */
    public MessageDTO selectByPrimaryKey(Long id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    /**
     * @return
     */
    public List<MessageDTO> selectAll() {
        return messageMapper.selectAll();
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(MessageDTO record) {
        return messageMapper.updateByPrimaryKey(record);
    }
}