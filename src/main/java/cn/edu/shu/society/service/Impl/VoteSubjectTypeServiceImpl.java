package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import cn.edu.shu.society.entity.VoteSubjectType;
import cn.edu.shu.society.service.VoteSubjectTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VoteSubjectTypeServiceImpl implements VoteSubjectTypeService{
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectTypeServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(VoteSubjectTypeDTO record);

    /**
     * @param id
     * @return
     */
    public VoteSubjectTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<VoteSubjectTypeDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectTypeDTO record);
}