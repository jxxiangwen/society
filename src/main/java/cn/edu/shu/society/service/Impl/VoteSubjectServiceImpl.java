package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectDTO;
import cn.edu.shu.society.entity.VoteSubject;
import cn.edu.shu.society.repository.VoteSubjectMapper;
import cn.edu.shu.society.service.VoteSubjectService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Override
    public int deleteByPrimaryKey(Long id) {
        return voteSubjectMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(VoteSubjectDTO record) {
        return voteSubjectMapper.insert(BeanUtility.beanCopy(record, VoteSubject.class));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public VoteSubjectDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteSubjectMapper.selectByPrimaryKey(id), VoteSubjectDTO.class);
    }

    /**
     * @return
     */
    @Override
    public List<VoteSubjectDTO> selectAll() {
        List<VoteSubject> voteSubjectList = voteSubjectMapper.selectAll();
        Iterator<VoteSubject> iterator = voteSubjectList.iterator();
        List<VoteSubjectDTO> voteSubjectDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectDTO.class));
        }
        return voteSubjectDTOLinkedList;
    }

    @Override
    public List<VoteSubjectDTO> selectAllByVoteTopicId(Long voteTopicId) {
        List<VoteSubject> voteSubjectList = voteSubjectMapper.selectAllByVoteTopicId(voteTopicId);
        Iterator<VoteSubject> iterator = voteSubjectList.iterator();
        List<VoteSubjectDTO> voteSubjectDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectDTO.class));
        }
        return voteSubjectDTOLinkedList;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteSubjectDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VoteSubject> voteSubjectList = voteSubjectMapper.selectAll();
        PageInfo<VoteSubject> page = new PageInfo(voteSubjectList);
        Iterator<VoteSubject> iterator = voteSubjectList.iterator();
        List<VoteSubjectDTO> voteSubjectDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectDTO.class));
        }
        PageInfo<VoteSubjectDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteSubjectDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(VoteSubjectDTO record) {
        return voteSubjectMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubject.class));
    }

    @Override
    public String getSubjectTypeBySubjectId(Long id) {
        return voteSubjectMapper.getSubjectTypeBySubjectId(id);
    }
}