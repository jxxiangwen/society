package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteTypeDTO;
import cn.edu.shu.society.entity.VoteType;
import cn.edu.shu.society.enums.VoteError;
import cn.edu.shu.society.exception.AppException;
import cn.edu.shu.society.repository.VoteTopicMapper;
import cn.edu.shu.society.repository.VoteTypeMapper;
import cn.edu.shu.society.service.VoteTypeService;
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
public class VoteTypeServiceImpl implements VoteTypeService {
    private static Logger logger = LoggerFactory.getLogger(VoteTypeServiceImpl.class);
    @Autowired
    VoteTypeMapper voteTypeMapper;

    @Autowired
    VoteTopicMapper voteTopicMapper;

    /**
     * 删除前要判断是否能删除，该类别下有内容就不能被删除
     * @param id 要删除的id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        Long countNumber = voteTopicMapper.countByVoteTypeId(id);
        if(countNumber == null || 0 == countNumber){
            return voteTypeMapper.deleteByPrimaryKey(id);
        }else {
            throw new AppException(VoteError.VOTE_HAVE_OBJECT.getMsg(), VoteError.VOTE_HAVE_OBJECT.getCode());
        }
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(VoteTypeDTO record) {
        return voteTypeMapper.insert(BeanUtility.beanCopy(record, VoteType.class));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public VoteTypeDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteTypeMapper.selectByPrimaryKey(id), VoteTypeDTO.class);
    }

    /**
     * @return
     */
    @Override
    public List<VoteTypeDTO> selectAll() {
        List<VoteType> voteTypeList = voteTypeMapper.selectAll();
        Iterator<VoteType> iterator = voteTypeList.iterator();
        List<VoteTypeDTO> voteTypeDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTypeDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTypeDTO.class));
        }
        return voteTypeDTOLinkedList;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteTypeDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VoteType> voteTypeList = voteTypeMapper.selectAll();
        PageInfo<VoteType> page = new PageInfo(voteTypeList);
        Iterator<VoteType> iterator = voteTypeList.iterator();
        List<VoteTypeDTO> voteTypeDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTypeDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTypeDTO.class));
        }
        PageInfo<VoteTypeDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteTypeDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(VoteTypeDTO record) {
        return voteTypeMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteType.class));
    }
}