package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.MessageDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<MessageDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MessageDTO record);
}