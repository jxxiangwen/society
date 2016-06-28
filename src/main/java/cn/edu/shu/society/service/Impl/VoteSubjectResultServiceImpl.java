package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectResultDTO;
import cn.edu.shu.society.entity.VoteSubjectResult;
import cn.edu.shu.society.service.VoteSubjectResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VoteSubjectResultServiceImpl implements VoteSubjectResultService{
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectResultServiceImpl.class);
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    public int insert(VoteSubjectResultDTO record);

    /**
     * @param id
     * @return
     */
    public VoteSubjectResultDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    public List<VoteSubjectResultDTO> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectResultDTO record);
}