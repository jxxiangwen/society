package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteTypeDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VoteTypeService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteTypeDTO record);

    /**
     * @param id
     * @return
     */
    VoteTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteTypeDTO> selectAll();

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<VoteTypeDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteTypeDTO record);

    /**
     *
     * @param id
     * @return
     */
    String getParentTypeNameById(Long id);

    Long getTypeIdByTypeName(String typeName);
}