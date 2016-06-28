package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectResultDTO;
import cn.edu.shu.society.entity.VoteSubjectResult;
import cn.edu.shu.society.repository.VoteSubjectResultMapper;
import cn.edu.shu.society.service.VoteSubjectResultService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VoteSubjectResultServiceImpl implements VoteSubjectResultService{
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectResultServiceImpl.class);

    @Autowired
    VoteSubjectResultMapper voteSubjectResultMapper;
    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id){
        return voteSubjectResultMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteSubjectResultDTO record){
        return voteSubjectResultMapper.insert(BeanUtility.beanCopy(record, VoteSubjectResult.class));
    }

    /**
     * @param id
     * @return
     */
    public VoteSubjectResultDTO selectByPrimaryKey(Long id){
        return BeanUtility.beanCopy(voteSubjectResultMapper.selectByPrimaryKey(id), VoteSubjectResultDTO.class);
    }

    /**
     * @return
     */
    public List<VoteSubjectResultDTO> selectAll(){
        List<VoteSubjectResult> voteSubjectResultList = voteSubjectResultMapper.selectAll();
        Iterator<VoteSubjectResult> iterator = voteSubjectResultList.iterator();
        List<VoteSubjectResultDTO> voteSubjectResultDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectResultDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectResultDTO.class));
        }
        return voteSubjectResultDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectResultDTO record){
        return voteSubjectResultMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubjectResult.class));
    }
}