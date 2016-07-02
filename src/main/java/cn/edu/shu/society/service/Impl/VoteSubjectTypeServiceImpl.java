package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import cn.edu.shu.society.entity.VoteSubjectType;
import cn.edu.shu.society.repository.VoteSubjectTypeMapper;
import cn.edu.shu.society.service.VoteSubjectTypeService;
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
public class VoteSubjectTypeServiceImpl implements VoteSubjectTypeService {
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectTypeServiceImpl.class);

    @Autowired
    VoteSubjectTypeMapper voteSubjectTypeMapper;

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return voteSubjectTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(VoteSubjectTypeDTO record) {
        return voteSubjectTypeMapper.insert(BeanUtility.beanCopy(record, VoteSubjectType.class));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public VoteSubjectTypeDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteSubjectTypeMapper.selectByPrimaryKey(id), VoteSubjectTypeDTO.class);
    }

    /**
     * @return
     */
    @Override
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
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteSubjectTypeDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VoteSubjectType> voteSubjectTypeList = voteSubjectTypeMapper.selectAll();
        PageInfo<VoteSubjectType> page = new PageInfo(voteSubjectTypeList);
        Iterator<VoteSubjectType> iterator = voteSubjectTypeList.iterator();
        List<VoteSubjectTypeDTO> voteSubjectTypeDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectTypeDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectTypeDTO.class));
        }
        PageInfo<VoteSubjectTypeDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteSubjectTypeDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(VoteSubjectTypeDTO record) {
        return voteSubjectTypeMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubjectType.class));
    }
}