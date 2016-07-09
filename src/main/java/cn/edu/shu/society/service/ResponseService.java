package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.ResponseDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ResponseService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(ResponseDTO record);

    /**
     * @param id
     * @return
     */
    ResponseDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<ResponseDTO> selectAll();

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<ResponseDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(ResponseDTO record);

    List<ResponseDTO> selectByMessageId(Long messageId);

}