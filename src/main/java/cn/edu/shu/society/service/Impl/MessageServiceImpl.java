package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.entity.Message;
import cn.edu.shu.society.repository.MessageMapper;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
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
        return messageMapper.insert(BeanUtility.beanCopy(record, Message.class));
    }

    /**
     * @param id
     * @return
     */
    public MessageDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(messageMapper.selectByPrimaryKey(id), MessageDTO.class);
    }

    /**
     * @return
     */
    public List<MessageDTO> selectAll() {
        List<Message> messageList = messageMapper.selectAll();
        Iterator<Message> iterator = messageList.iterator();
        List<MessageDTO> messageDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            messageDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), MessageDTO.class));
        }
        return messageDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(MessageDTO record) {
        return messageMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, Message.class));
    }
}