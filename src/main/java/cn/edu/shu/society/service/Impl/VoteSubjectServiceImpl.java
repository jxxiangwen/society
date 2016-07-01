package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectDTO;
import cn.edu.shu.society.entity.VoteSubject;
import cn.edu.shu.society.repository.VoteSubjectMapper;
import cn.edu.shu.society.service.VoteSubjectService;
import cn.edu.shu.society.util.BeanUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class VoteSubjectServiceImpl implements VoteSubjectService {
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectServiceImpl.class);

    @Autowired
    VoteSubjectMapper voteSubjectMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return voteSubjectMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(VoteSubjectDTO record) {
        return voteSubjectMapper.insert(BeanUtility.beanCopy(record, VoteSubject.class));
    }

    /**
     * @param id
     * @return
     */
    public VoteSubjectDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteSubjectMapper.selectByPrimaryKey(id), VoteSubjectDTO.class);
    }

    /**
     * @return
     */
    public List<VoteSubjectDTO> selectAll() {
        List<VoteSubject> voteSubjectList = voteSubjectMapper.selectAll();
        Iterator<VoteSubject> iterator = voteSubjectList.iterator();
        List<VoteSubjectDTO> voteSubjectDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectDTO.class));
        }
        return voteSubjectDTOLinkedList;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectDTO record) {
        return voteSubjectMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubject.class));
    }
}