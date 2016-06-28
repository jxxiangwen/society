package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteTypeDTO;
import cn.edu.shu.society.entity.VoteType;
import cn.edu.shu.society.repository.VoteTypeMapper;
import cn.edu.shu.society.service.VoteTypeService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VoteTypeServiceImpl implements VoteTypeService{
    private static Logger logger = LoggerFactory.getLogger(VoteTypeServiceImpl.class);
    @Autowired
    VoteTypeMapper voteTypeMapper;
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return voteTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteTypeDTO record) {
        return voteTypeMapper.insert(BeanUtility.beanCopy(record, VoteType.class));
    }

    /**
     * @param id
     * @return
     */
    public VoteTypeDTO selectByPrimaryKey(Long id){
        return BeanUtility.beanCopy(voteTypeMapper.selectByPrimaryKey(id), VoteTypeDTO.class);
    }

    /**
     * @return
     */
    public List<VoteTypeDTO> selectAll(){
        List<VoteType> voteTypeList = voteTypeMapper.selectAll();
        Iterator<VoteType> iterator = voteTypeList.iterator();
        List<VoteTypeDTO> voteTypeDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTypeDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTypeDTO.class));
        }
        return voteTypeDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteTypeDTO record){
        return voteTypeMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteType.class));
    }
}