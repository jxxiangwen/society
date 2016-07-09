package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.MessageTypeDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<MessageTypeDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MessageTypeDTO record);

    /**
     * 根据留言类别ID查找回答接受者ID
     * @param userId
     * @return
     */
    List<MessageTypeDTO> selectByUserId(Long userId);

    List<MessageTypeDTO> selectByMessageTypeName(String typeName);
}