package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.VoteResultMap;
import cn.edu.shu.society.dto.VoteSubjectResultDTO;
import cn.edu.shu.society.entity.VoteSubject;
import cn.edu.shu.society.entity.VoteSubjectResult;
import cn.edu.shu.society.entity.VoteTopic;
import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.enums.VoteTypeEnums;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.repository.VoteSubjectMapper;
import cn.edu.shu.society.repository.VoteSubjectResultMapper;
import cn.edu.shu.society.repository.VoteTopicMapper;
import cn.edu.shu.society.repository.VoteTypeMapper;
import cn.edu.shu.society.service.VoteSubjectResultService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public Long countVoteNumberByResultVoteItemId(Long resultVoteItemId) {
        return voteSubjectResultMapper.countVoteNumberByResultVoteItemId(resultVoteItemId);
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

    /**
     * 保存投票结果
     * @param userId
     * @param id
     * @param voteResultMap
     * @return
     */
    public boolean saveVoteResult(Long userId, Long id, VoteResultMap voteResultMap) {
        VoteTopic voteTopic = voteTopicMapper.selectByPrimaryKey(id);
        String typeName = voteTypeMapper.getParentTypeNameById(voteTopic.getVoteTypeId());
        if ("记名投票".equals(typeName)) {
            Long count = voteSubjectResultMapper.isHaveVoted(userId);
            if (null != count && 0 < count) {
                throw new AppViewException("请勿重复投票");
            }
        } else {
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
        }
        return true;
    }
}