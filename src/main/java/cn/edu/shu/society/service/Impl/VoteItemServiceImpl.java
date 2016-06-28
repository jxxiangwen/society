package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteItemDTO;
import cn.edu.shu.society.entity.VoteItem;
import cn.edu.shu.society.service.VoteItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VoteItemServiceImpl implements VoteItemService{
    private static Logger logger = LoggerFactory.getLogger(VoteItemServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(VoteItemDTO record);

    /**
     * @param id
     * @return
     */
    public VoteItemDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<VoteItemDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteItemDTO record);
}