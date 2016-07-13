package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.*;
import cn.edu.shu.society.entity.*;
import cn.edu.shu.society.enums.VoteError;
import cn.edu.shu.society.exception.AppException;
import cn.edu.shu.society.repository.*;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class VoteTopicServiceImpl implements VoteTopicService {
    private static Logger logger = LoggerFactory.getLogger(VoteTopicServiceImpl.class);

    @Autowired
    VoteTopicMapper voteTopicMapper;

    @Autowired
    VoteSubjectMapper voteSubjectMapper;

    @Autowired
    VoteSubjectResultMapper voteSubjectResultMapper;

    @Autowired
    VoteSubjectTypeMapper voteSubjectTypeMapper;

    @Autowired
    VoteTopicNumberMapper voteTopicNumberMapper;

    @Autowired
    VoteTypeMapper voteTypeMapper;

    @Autowired
    VoteItemMapper voteItemMapper;

    private Map<Long, String> subjectTypeNameMap = new HashMap<>();

    public void setSubjectTypeNameMap(List<VoteSubjectType> voteSubjectTypeList) {
        subjectTypeNameMap.clear();
        if (CollectionUtils.isEmpty(voteSubjectTypeList)) {
            throw new AppException(VoteError.VOTE_TYPE_NOT_EXIST.getMsg(), VoteError.VOTE_TYPE_NOT_EXIST.getCode());
        }
        for (VoteSubjectType voteSubjectType : voteSubjectTypeList) {
            subjectTypeNameMap.put(voteSubjectType.getId(), voteSubjectType.getTypeName());
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return voteTopicMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(VoteTopicDTO record) {
        return voteTopicMapper.insert(BeanUtility.beanCopy(record, VoteTopic.class));
    }


    /**
     * @param id
     * @return
     */
    @Override
    public VoteTopicDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteTopicMapper.selectByPrimaryKey(id), VoteTopicDTO.class);
    }


    /**
     * @return
     */
    @Override
    public List<VoteTopicDTO> selectAll() {
        List<VoteTopic> voteTopicList = voteTopicMapper.selectAll();
        Iterator<VoteTopic> iterator = voteTopicList.iterator();
        List<VoteTopicDTO> voteTopicDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTopicDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTopicDTO.class));
        }
        return voteTopicDTOLinkedList;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteTopicDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VoteTopic> voteTopicList = voteTopicMapper.selectAll();
        PageInfo<VoteTopic> page = new PageInfo(voteTopicList);
        Iterator<VoteTopic> iterator = voteTopicList.iterator();
        List<VoteTopicDTO> voteTopicDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTopicDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTopicDTO.class));
        }
        PageInfo<VoteTopicDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteTopicDTOLinkedList);
        return page1;
    }

    @Override
    public List<VoteTopicDTO> selectAllByVoteTypeId(Long voteTypeId) {
        List<VoteTopic> voteTopicList = voteTopicMapper.selectAllByVoteTypeId(voteTypeId);
        Iterator<VoteTopic> iterator = voteTopicList.iterator();
        List<VoteTopicDTO> voteTopicDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTopicDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTopicDTO.class));
        }
        return voteTopicDTOLinkedList;
    }

    /**
     * @param voteTypeId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteTopicDTO> selectByVoteTypeIdAndPage(Long voteTypeId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "create_time desc");
        List<VoteTopic> voteTopicList = voteTopicMapper.selectAllByVoteTypeId(voteTypeId);
        PageInfo<VoteTopic> page = new PageInfo(voteTopicList);
        Iterator<VoteTopic> iterator = voteTopicList.iterator();
        List<VoteTopicDTO> voteTopicDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTopicDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTopicDTO.class));
        }
        PageInfo<VoteTopicDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteTopicDTOLinkedList);
        return page1;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<VoteTopicDTO> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "create_time desc");
        List<VoteTopic> voteTopicList = voteTopicMapper.selectAll();
        PageInfo<VoteTopic> page = new PageInfo(voteTopicList);
        Iterator<VoteTopic> iterator = voteTopicList.iterator();
        List<VoteTopicDTO> voteTopicDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteTopicDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteTopicDTO.class));
        }
        PageInfo<VoteTopicDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(voteTopicDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(VoteTopicDTO record) {
        return voteTopicMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteTopic.class));
    }

    @Override
    public Long countByVoteTypeId(Long voteTypeId) {
        return voteTopicMapper.countByVoteTypeId(voteTypeId);
    }

    /**
     * 从数据库中导出投票的原始结果。
     * 投票调研编号，创建日期，创建人，有效期开始日期，有效期截止日期。
     * 题目名称，类别，题目选项投票数
     * 对于记名投票，还要导出投票人，投票日期
     *
     * @param voteTopicId
     * @return
     */
    @Override
    public List<VoteResultOutDTO> exportTopicResult(Long voteTopicId) {
        List<VoteResultOutDTO> voteResultOutDTOList = new LinkedList<>();
        //先查出投票主题
        VoteTopic voteTopic = voteTopicMapper.selectByPrimaryKey(voteTopicId);
        if (null == voteTopic) {
            throw new AppException(VoteError.VOTE_NOT_EXIST.getMsg(), VoteError.VOTE_NOT_EXIST.getCode());
        }
        //根据投票主题查出投票项目
        List<VoteSubject> voteSubjectList = voteSubjectMapper.selectAllByVoteTopicId(voteTopicId);
        if (null == voteSubjectList || 0 == voteSubjectList.size()) {
            throw new AppException(VoteError.VOTE_SUBJECT_NOT_EXIST.getMsg(), VoteError.VOTE_SUBJECT_NOT_EXIST.getCode());
        }
        //查询有多少人投票类别
        List<VoteSubjectType> voteSubjectTypeList = voteSubjectTypeMapper.selectAll();
        setSubjectTypeNameMap(voteSubjectTypeList);
        Long voteNumber = voteTopicNumberMapper.selectByVoteTopicId(voteTopicId);
        for (VoteSubject voteSubject : voteSubjectList) {
            //查询某投票项目的投票结果
            List<VoteSubjectResult> voteSubjectResultList = voteSubjectResultMapper.selectBySubjectId(voteSubject.getId());
            VoteResultOutDTO voteResultOutDTO = new VoteResultOutDTO(voteTopic);
            for (VoteSubjectResult voteSubjectResult : voteSubjectResultList) {
                //设置投票项目标题和投票项目类别
                voteResultOutDTO.setVoteSubject(voteSubject, this.subjectTypeNameMap);
                //设置投票数
                voteResultOutDTO.setVoteSubjectNumber(voteNumber);
                Long userId = voteSubjectResult.getUserId();
                if (null != userId || 0 != userId) {
                    voteResultOutDTO.getVoteUserMap().put(userId, new Date(voteSubjectResult.getCreateTime()));
                }
            }
            voteResultOutDTOList.add(voteResultOutDTO);
        }
        return voteResultOutDTOList;
    }

    @Override
    public VoteTopicDTO selectListByPrimaryKey(Long id) {
        VoteTopic voteTopic = voteTopicMapper.selectListByPrimaryKey(id);
        return BeanUtility.convertTopicToDTO(voteTopic);
    }

    /**
     * 保存或者结果
     *
     * @param topicDTO
     * @param userId
     * @param idMap
     */
    @Override
    public void saveOrUpdate(TopicDTO topicDTO, Long userId, Map<String, Set<Long>> idMap) {
        Set<Long> subjectIdSet = null;
        Set<Long> itemIdSet = null;
        if (null != idMap) {
            subjectIdSet = idMap.get("subjectId");
            itemIdSet = idMap.get("itemId");
        }
        VoteTopic voteTopic = new VoteTopic();
        voteTopic.setUserId(userId);
        voteTopic.setVoteTypeId(voteTypeMapper.getTypeIdByTypeName(topicDTO.getTopicTypeName()));
        voteTopic.setStartTime(topicDTO.getTopicStartTime());
        voteTopic.setEndTime(topicDTO.getTopicEndTime());
        voteTopic.setTitle(topicDTO.getTopicTitle());
        if(null == topicDTO.getTopicId()){
            voteTopicMapper.insert(voteTopic);
        }else {
            voteTopic.setId(topicDTO.getTopicId());
            voteTopicMapper.updateByPrimaryKey(voteTopic);
        }
        if (null == topicDTO.getSubject() || 0 == topicDTO.getSubject().size()) {
            throw new AppException(VoteError.VOTE_SUBJECT_NOT_EXIST.getMsg(), VoteError.VOTE_SUBJECT_NOT_EXIST.getCode());
        }
        for (SubjectDTO subjectDTO : topicDTO.getSubject()) {
            //跳过空索引导致的null
            if (StringUtils.isEmpty(subjectDTO.getSubjectTitle())) {
                continue;
            }
            VoteSubject voteSubject = new VoteSubject();
            voteSubject.setTitle(subjectDTO.getSubjectTitle());
            voteSubject.setVoteTopicId(voteTopic.getId());
            voteSubject.setVoteSubjectTypeId(voteSubjectTypeMapper.selectIdByTypeName(subjectDTO.getSubjectTypeName()));
            if(null == subjectDTO.getSubjectId()){
                voteSubjectMapper.insert(voteSubject);
            }else {
                voteSubject.setId(subjectDTO.getSubjectId());
                voteSubjectMapper.updateByPrimaryKey(voteSubject);
                if(null != subjectIdSet){
                    subjectIdSet.remove(subjectDTO.getSubjectId());
                }
            }
            if (null == subjectDTO.getItem() || 0 == subjectDTO.getItem().size()) {
                //主观题
                continue;
            }
            for (ItemDTO itemDTO : subjectDTO.getItem()) {
                //跳过空索引导致的null
                if (StringUtils.isEmpty(itemDTO.getItemTitle())) {
                    continue;
                }
                VoteItem voteItem = new VoteItem();
                voteItem.setVoteSubjectId(voteSubject.getId());
                voteItem.setContent(itemDTO.getItemTitle());
                if(null == itemDTO.getItemId()){
                    voteItemMapper.insert(voteItem);
                }else {
                    voteItem.setId(itemDTO.getItemId());
                    voteItemMapper.updateByPrimaryKey(voteItem);
                    if(null != subjectIdSet){
                        itemIdSet.remove(itemDTO.getItemId());
                    }
                }
            }
        }
        if(null != subjectIdSet){
            for (Long id : subjectIdSet){
                voteSubjectMapper.deleteByPrimaryKey(id);
            }
        }
        if(null != itemIdSet){
            for (Long id : itemIdSet){
                voteItemMapper.deleteByPrimaryKey(id);
            }
        }
    }
}