package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectResultDTO;
import cn.edu.shu.society.entity.VoteSubjectResult;
import cn.edu.shu.society.repository.VoteSubjectResultMapper;
import cn.edu.shu.society.service.VoteSubjectResultService;
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
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteSubjectResultDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VoteSubjectResult> voteSubjectResultList = voteSubjectResultMapper.selectAll();
        PageInfo<VoteSubjectResult> page = new PageInfo(voteSubjectResultList);
        Iterator<VoteSubjectResult> iterator = voteSubjectResultList.iterator();
        List<VoteSubjectResultDTO> voteSubjectResultDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectResultDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectResultDTO.class));
        }
        PageInfo<VoteSubjectResultDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteSubjectResultDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(VoteSubjectResultDTO record){
        return voteSubjectResultMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubjectResult.class));
    }
}