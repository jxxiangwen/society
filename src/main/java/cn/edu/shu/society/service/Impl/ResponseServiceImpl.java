package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.ResponseDTO;
import cn.edu.shu.society.entity.Response;
import cn.edu.shu.society.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResponseServiceImpl implements ResponseService{
    private static Logger logger = LoggerFactory.getLogger(ResponseServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(ResponseDTO record);

    /**
     * @param id
     * @return
     */
    public ResponseDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<ResponseDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(ResponseDTO record);
}