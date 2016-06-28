package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.entity.VoteType;
import cn.edu.shu.society.repository.VoteTypeMapper;
import cn.edu.shu.society.service.VoteTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VoteTypeServiceImpl implements VoteTypeService{
    private static Logger logger = LoggerFactory.getLogger(VoteTypeServiceImpl.class);
    @Autowired
    VoteTypeMapper voteTypeMapper;
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id){
        return voteTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteType record){
        return voteTypeMapper.insert(record);
    }

    /**
     * @param id
     * @return
     */
    public VoteType selectByPrimaryKey(Long id){
        return voteTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * @return
     */
    public List<VoteType> selectAll();

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteType record);
}