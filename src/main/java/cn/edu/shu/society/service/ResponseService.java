package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.ResponseDTO;

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
     * @param record
     * @return
     */
    int updateByPrimaryKey(ResponseDTO record);
}