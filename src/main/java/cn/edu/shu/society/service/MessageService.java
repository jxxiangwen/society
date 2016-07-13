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
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<MessageDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MessageDTO record);

    PageInfo<MessageDTO> selectByMessageTypeIdAndPassStatus(int pageNum, int pageSize, Long messageTypeId, boolean[] passStatusArr);

    Long selectCountByMessageTypeIdAndPassStatus(Long messageTypeId, boolean[] passStatusArr);

    PageInfo<MessageDTO> selectByUserIdAndPassStatus(int pageNum, int pageSize, Long userId, boolean[] passStatusArr);

    int updateIsPassed(Long messageId, boolean isPassed);

}