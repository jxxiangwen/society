package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.MessageTypeDTO;
import cn.edu.shu.society.entity.MessageType;
import cn.edu.shu.society.repository.MessageTypeMapper;
import cn.edu.shu.society.service.MessageTypeService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class MessageTypeServiceImpl implements MessageTypeService {
    private static Logger logger = LoggerFactory.getLogger(MessageTypeServiceImpl.class);

    @Autowired
    MessageTypeMapper messageTypeMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return messageTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(MessageTypeDTO record) {
        return messageTypeMapper.insert(BeanUtility.beanCopy(record, MessageType.class));
    }

    /**
     * @param id
     * @return
     */
    public MessageTypeDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(messageTypeMapper.selectByPrimaryKey(id), MessageTypeDTO.class);
    }

    /**
     * @return
     */
    public List<MessageTypeDTO> selectAll() {
        List<MessageType> messageTypeList = messageTypeMapper.selectAll();
        Iterator<MessageType> iterator = messageTypeList.iterator();
        List<MessageTypeDTO> messageTypeDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            messageTypeDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), MessageTypeDTO.class));
        }
        return messageTypeDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(MessageTypeDTO record) {
        return messageTypeMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, MessageType.class));
    }
}