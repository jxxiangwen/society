package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import cn.edu.shu.society.entity.VoteSubjectType;
import cn.edu.shu.society.repository.VoteSubjectTypeMapper;
import cn.edu.shu.society.service.VoteSubjectTypeService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VoteSubjectTypeServiceImpl implements VoteSubjectTypeService {
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectTypeServiceImpl.class);

    @Autowired
    VoteSubjectTypeMapper voteSubjectTypeMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return voteSubjectTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteSubjectTypeDTO record) {
        return voteSubjectTypeMapper.insert(BeanUtility.beanCopy(record, VoteSubjectType.class));
    }

    /**
     * @param id
     * @return
     */
    public VoteSubjectTypeDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteSubjectTypeMapper.selectByPrimaryKey(id), VoteSubjectTypeDTO.class);
    }

    /**
     * @return
     */
    public List<VoteSubjectTypeDTO> selectAll() {
        List<VoteSubjectType> voteSubjectTypeList = voteSubjectTypeMapper.selectAll();
        Iterator<VoteSubjectType> iterator = voteSubjectTypeList.iterator();
        List<VoteSubjectTypeDTO> voteSubjectTypeDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectTypeDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectTypeDTO.class));
        }
        return voteSubjectTypeDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectTypeDTO record) {
        return voteSubjectTypeMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubjectType.class));
    }
}