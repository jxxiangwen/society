package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectDTO;
import cn.edu.shu.society.entity.VoteSubject;
import cn.edu.shu.society.service.VoteSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VoteSubjectServiceImpl implements VoteSubjectService{
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(VoteSubjectDTO record);

    /**
     * @param id
     * @return
     */
    public VoteSubjectDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<VoteSubjectDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectDTO record);
}