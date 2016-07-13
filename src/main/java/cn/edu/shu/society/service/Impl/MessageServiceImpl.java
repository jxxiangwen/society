package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.MessageDTO;
import cn.edu.shu.society.entity.Message;
import cn.edu.shu.society.repository.MessageMapper;
import cn.edu.shu.society.service.MessageService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Service
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
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<MessageDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "update_time desc");
        List<Message> messageList = messageMapper.selectAll();
        PageInfo<Message> page = new PageInfo(messageList);
        Iterator<Message> iterator = messageList.iterator();
        List<MessageDTO> messageDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            messageDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), MessageDTO.class));
        }
        PageInfo<MessageDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(messageDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(MessageDTO record) {
        return messageMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, Message.class));
    }

    @Override
    public PageInfo<MessageDTO> selectByMessageTypeIdAndPassStatus(int pageNum, int pageSize, Long messageTypeId, boolean[] passStatusArr) {
        PageHelper.startPage(pageNum, pageSize, "update_time desc");
        List<Message> messageList = messageMapper.selectByMessageTypeIdAndPassStatus(messageTypeId, passStatusArr);
        PageInfo<Message> page = new PageInfo(messageList);
        Iterator<Message> iterator = messageList.iterator();
        List<MessageDTO> messageDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            messageDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), MessageDTO.class));
        }
        PageInfo<MessageDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(messageDTOLinkedList);
        return page1;
    }

    @Override
    public Long selectCountByMessageTypeIdAndPassStatus(Long messageTypeId, boolean[] passStatusArr) {
        return messageMapper.selectCountByMessageTypeIdAndPassStatus(messageTypeId, passStatusArr);
    }

    @Override
    public PageInfo<MessageDTO> selectByUserIdAndPassStatus(int pageNum, int pageSize, Long userId, boolean[] passStatusArr) {
        PageHelper.startPage(pageNum, pageSize, "update_time desc");
        List<Message> messageList = messageMapper.selectByUserIdAndPassStatus(userId, passStatusArr);
        PageInfo<Message> page = new PageInfo(messageList);
        Iterator<Message> iterator = messageList.iterator();
        List<MessageDTO> messageDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            messageDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), MessageDTO.class));
        }
        PageInfo<MessageDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(messageDTOLinkedList);
        return page1;
    }

    @Override
    public int updateIsPassed(Long messageId, boolean isPassed) {
        return messageMapper.updateIsPassed(messageId, true);
    }

}