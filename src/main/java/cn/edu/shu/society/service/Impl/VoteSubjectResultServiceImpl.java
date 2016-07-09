package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.*;
import cn.edu.shu.society.entity.VoteSubject;
import cn.edu.shu.society.entity.VoteSubjectResult;
import cn.edu.shu.society.entity.VoteTopic;
import cn.edu.shu.society.entity.VoteTopicNumber;
import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.enums.VoteTypeEnums;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.repository.*;
import cn.edu.shu.society.service.VoteSubjectResultService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class VoteSubjectResultServiceImpl implements VoteSubjectResultService {
    private static Logger logger = LoggerFactory.getLogger(VoteSubjectResultServiceImpl.class);

    @Autowired
    VoteSubjectResultMapper voteSubjectResultMapper;

    @Autowired
    VoteSubjectMapper voteSubjectMapper;

    @Autowired
    VoteTopicMapper voteTopicMapper;

    @Autowired
    VoteTypeMapper voteTypeMapper;

    @Autowired
    VoteTopicNumberMapper voteTopicNumberMapper;

    @Autowired
    VoteItemMapper voteItemMapper;

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return voteSubjectResultMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(VoteSubjectResultDTO record) {
        return voteSubjectResultMapper.insert(BeanUtility.beanCopy(record, VoteSubjectResult.class));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public VoteSubjectResultDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(voteSubjectResultMapper.selectByPrimaryKey(id), VoteSubjectResultDTO.class);
    }

    /**
     * @return
     */
    @Override
    public List<VoteSubjectResultDTO> selectAll() {
        List<VoteSubjectResult> voteSubjectResultList = voteSubjectResultMapper.selectAll();
        Iterator<VoteSubjectResult> iterator = voteSubjectResultList.iterator();
        List<VoteSubjectResultDTO> voteSubjectResultDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectResultDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectResultDTO.class));
        }
        return voteSubjectResultDTOLinkedList;
    }

    /**
     * 根据项目ID和用户ID查询投票结果
     *
     * @param voteSubjectId
     * @param userId
     * @return
     */
    @Override
    public List<VoteSubjectResultDTO> selectBySubjectIdAndUserId(Long voteSubjectId, Long userId) {
        List<VoteSubjectResult> voteSubjectResultList = voteSubjectResultMapper.selectBySubjectIdAndUserId(voteSubjectId, userId);
        Iterator<VoteSubjectResult> iterator = voteSubjectResultList.iterator();
        List<VoteSubjectResultDTO> voteSubjectResultDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            voteSubjectResultDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), VoteSubjectResultDTO.class));
        }
        return voteSubjectResultDTOLinkedList;
    }

    /**
     * @param voteSubjectId
     * @return
     */
    @Override
    public List<VoteSubjectResultDTO> selectBySubjectId(Long voteSubjectId) {
        List<VoteSubjectResult> voteSubjectResultList = voteSubjectResultMapper.selectBySubjectId(voteSubjectId);
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
    @Override
    public int updateByPrimaryKey(VoteSubjectResultDTO record) {
        return voteSubjectResultMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, VoteSubjectResult.class));
    }

    /**
     * @param resultVoteItemId
     * @return
     */
    @Override
    public Long countVoteNumberByVoteItemId(Long resultVoteItemId) {
        return voteSubjectResultMapper.countVoteNumberByVoteItemId(resultVoteItemId);
    }

    /**
     * 用户是否投过票
     *
     * @param userId
     * @return
     */
    @Override
    public Long isHaveVoted(Long userId) {
        return voteSubjectResultMapper.isHaveVoted(userId);
    }

    @Override
    public Long countVoteNumberByList(List<Long> list) {
        return voteSubjectResultMapper.countVoteNumberByList(list);
    }

    /**
     * 保存投票结果
     *
     * @param userId
     * @param voteTopicId
     * @param voteResultMap
     * @return
     */
    public boolean saveVoteResult(Long userId, Long voteTopicId, VoteResultMap voteResultMap) {
        VoteTopic voteTopic = voteTopicMapper.selectByPrimaryKey(voteTopicId);
        String typeName = voteTypeMapper.getParentTypeNameById(voteTopic.getVoteTypeId());
        if ("记名投票".equals(typeName)) {
            Long count = voteSubjectResultMapper.isHaveVoted(userId);
            if (null != count && 0 < count) {
                throw new AppViewException("请勿重复投票");
            }
        }
        Iterator<Map.Entry<Long, String>> iterator = voteResultMap.getVoteMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, String> kv = iterator.next();
            Long key = kv.getKey();
            String value = kv.getValue();
            String subjectType = voteSubjectMapper.getSubjectTypeBySubjectId(key);
            VoteSubjectResult voteSubjectResult;
            if (VoteTypeEnums.CHECKBOX.getType().equals(subjectType.trim())) {
                //多选题
                String[] values = value.split(",");
                for (String s : values) {
                    voteSubjectResult = new VoteSubjectResult();
                    voteSubjectResult.setVoteSubjectId(key);
                    voteSubjectResult.setResultVoteItemId(Long.parseLong(s));
                    voteSubjectResult.setUserId(userId);
                    voteSubjectResultMapper.insert(voteSubjectResult);
                }
            } else if (VoteTypeEnums.RADIO.getType().equals(subjectType.trim())) {
                //单选题
                voteSubjectResult = new VoteSubjectResult();
                voteSubjectResult.setUserId(userId);
                voteSubjectResult.setVoteSubjectId(key);
                voteSubjectResult.setResultVoteItemId(Long.parseLong(value));
                voteSubjectResultMapper.insert(voteSubjectResult);
            } else if (VoteTypeEnums.OPINION.getType().equals(subjectType.trim())) {
                //主观题
                voteSubjectResult = new VoteSubjectResult();
                voteSubjectResult.setUserId(userId);
                voteSubjectResult.setVoteSubjectId(key);
                voteSubjectResult.setContentResult(value);
                voteSubjectResultMapper.insert(voteSubjectResult);
            } else {
                throw new AppViewException(ClientError.SYSTEM_WRONG.getMsg());
            }
        }

        VoteTopicNumber voteTopicNumber = voteTopicNumberMapper.selectObjectByVoteTopicId(voteTopicId);
        if (null == voteTopicNumber) {
            voteTopicNumber = new VoteTopicNumber();
            voteTopicNumber.setVoteTopicId(voteTopicId);
            voteTopicNumber.setVoteTopicVoteNumber(1L);
            voteTopicNumberMapper.insert(voteTopicNumber);
        } else {
            voteTopicNumberMapper.addVoteNumber(voteTopicNumber);
        }
        return true;
    }

    /**
     * 获取投票结果
     *
     * @param voteTopicId
     * @return
     */
    public VoteTopicDTO getVoteResult(Long voteTopicId) {
        VoteTopicDTO voteTopicDTO = BeanUtility.convertTopicToDTO(voteTopicMapper.selectListByPrimaryKey(voteTopicId));
        if (!CollectionUtils.isEmpty(voteTopicDTO.getVoteSubjectList())) {
            for (VoteSubjectDTO voteSubjectDTO : voteTopicDTO.getVoteSubjectList()) {
                if (!CollectionUtils.isEmpty(voteSubjectDTO.getVoteItemList())) {
                    for (VoteItemDTO voteItemDTO : voteSubjectDTO.getVoteItemList()) {
                        //得到百分比
//                        Long value = voteSubjectResultMapper.countVoteNumberByVoteItemId(voteItemDTO.getId() /
//                                voteSubjectResultMapper.countVoteNumberByList(voteItemMapper.selectItemIdBySubject(voteSubjectDTO.getId())));
                        voteItemDTO.setVoteNum(voteSubjectResultMapper.countVoteNumberByVoteItemId(voteItemDTO.getId()));
                    }
                }

            }
        }
        return voteTopicDTO;
    }
}