package cn.edu.shu.society.util;

import cn.edu.shu.society.dto.VoteItemDTO;
import cn.edu.shu.society.dto.VoteSubjectDTO;
import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.entity.VoteTopic;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


public class BeanUtility {
    public static <T> T beanCopy(Object fromBean, Class<T> type) {
        T toBean = null;
        try {
            toBean = type.newInstance(); // 创建 JavaBean 对象
            if (fromBean == null || toBean == null) {
                return null;
            }
//            BeanCopier.create(fromBean.getClass(),toBean.getClass(),true);
            BeanUtils.copyProperties(fromBean, toBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return toBean;
    }

    public static <T> T beanCopy(Object fromBean, Class<T> type,String... ignoreProperties) {
        T toBean = null;
        try {
            toBean = type.newInstance(); // 创建 JavaBean 对象
            if (fromBean == null || toBean == null) {
                return null;
            }
//            BeanCopier.create(fromBean.getClass(),toBean.getClass(),true);
            BeanUtils.copyProperties(fromBean, toBean,ignoreProperties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return toBean;
    }

    public static List convertOtherBeanList(List list, Class tartgetClass) {
        List resultList = new ArrayList<>();
        for (int i = 0; list != null && i < list.size(); i++) {
            resultList.add(beanCopy(list.get(i), tartgetClass));
        }
        return resultList;
    }

    public static VoteTopicDTO convertTopicToDTO(VoteTopic voteTopic){
        VoteTopicDTO voteTopicDTO = BeanUtility.beanCopy(voteTopic, VoteTopicDTO.class);
        //先清除
        voteTopicDTO.setVoteSubjectList(new ArrayList<>());
        if (!CollectionUtils.isEmpty(voteTopic.getVoteSubjectList())) {
            for (int i = 0; i < voteTopic.getVoteSubjectList().size(); i++) {
                voteTopicDTO.getVoteSubjectList().add(i,BeanUtility.beanCopy(voteTopic.getVoteSubjectList().get(i), VoteSubjectDTO.class));
                //先清除
                voteTopicDTO.getVoteSubjectList().get(i).setVoteItemList(new ArrayList<>());
                if (!CollectionUtils.isEmpty(voteTopic.getVoteSubjectList().get(i).getVoteItemList())) {
                    for (int j = 0; j < voteTopic.getVoteSubjectList().get(i).getVoteItemList().size(); j++) {
                        voteTopicDTO.getVoteSubjectList().get(i).getVoteItemList().add(j,BeanUtility.beanCopy(voteTopic.getVoteSubjectList().get(i).getVoteItemList().get(j), VoteItemDTO.class));
                    }
                }
            }
        }
        return voteTopicDTO;
    }
}