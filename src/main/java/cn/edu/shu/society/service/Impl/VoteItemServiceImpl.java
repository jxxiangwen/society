package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteItemDTO;
import cn.edu.shu.society.entity.VoteItem;
import cn.edu.shu.society.repository.VoteItemMapper;
import cn.edu.shu.society.service.VoteItemService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VoteItemServiceImpl implements VoteItemService {
    private static Logger logger = LoggerFactory.getLogger(VoteItemServiceImpl.class);

    @Autowired
    VoteItemMapper voteItemMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return voteItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteItemDTO record) {
        return voteItemMapper.insert(BeanUtility.beanCopy(record, VoteItem.class));
    }

    /**
     * @param id
     * @return
     */
    public VoteItemDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteItemMapper.selectByPrimaryKey(id), VoteItemDTO.class);
    }

    /**
     * @return
     */
    public List<VoteItemDTO> selectAll() {
        List<VoteItem> voteItemList = voteItemMapper.selectAll();
        Iterator<VoteItem> iterator = voteItemList.iterator();
        List<VoteItemDTO> voteItemDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteItemDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteItemDTO.class));
        }
        return voteItemDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteItemDTO record) {
        return voteItemMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteItem.class));
    }
}