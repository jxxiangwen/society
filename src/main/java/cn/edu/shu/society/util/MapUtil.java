package cn.edu.shu.society.util;

import cn.edu.shu.society.dto.VoteItemDTO;
import cn.edu.shu.society.dto.VoteSubjectDTO;
import cn.edu.shu.society.dto.VoteTopicDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jxxia on 2016/7/12 0012.
 */
public class MapUtil {
    public static Map<String, Set<Long>> getIdMapByTopic(VoteTopicDTO voteTopicDTO) {
        Map<String, Set<Long>> idMap = new HashMap<>();
        Set<Long> subjectIdSet = new HashSet<>();
        Set<Long> itemIdSet = new HashSet<>();
        for (VoteSubjectDTO voteSubjectDTO : voteTopicDTO.getVoteSubjectList()) {
            subjectIdSet.add(voteSubjectDTO.getId());
            for (VoteItemDTO voteItemDTO : voteSubjectDTO.getVoteItemList()) {
                itemIdSet.add(voteItemDTO.getId());
            }
        }
        idMap.put("subjectId", subjectIdSet);
        idMap.put("itemId", itemIdSet);
        return idMap;
    }
}
