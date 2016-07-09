package cn.edu.shu.society.dto;

import cn.edu.shu.society.entity.VoteSubject;
import cn.edu.shu.society.entity.VoteTopic;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于导出投票结果
 * Created by jxxia on 2016/7/2 0002.
 */
public class VoteResultOutDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    //投票编号
    private Long id;
    //投票创建人
    private Long createUserId;
    //投票标题
    private String topicTitle;
    //开始时间
    private Long startTime;
    //结束时间
    private Long endTime;
    //投票项目标题
    private String subjectTitle;
    //投票项目类别
    private String voteSubjectTypeName;
    //投票数
    private Long voteSubjectNumber;
    //投票人和投票时间
    private Map<Long,Date> voteUserMap;

    public VoteResultOutDTO() {
        this.voteUserMap = new HashMap<>();
    }

    public VoteResultOutDTO(VoteTopic voteTopic) {
        this.id = voteTopic.getId();
        this.createUserId = voteTopic.getUserId();
        this.topicTitle = voteTopic.getTitle();
        this.startTime = voteTopic.getStartTime();
        this.endTime = voteTopic.getEndTime();
        this.voteUserMap = new HashMap<>();
    }

    public void setVoteSubject(VoteSubject voteSubject,Map<Long,String> subjectTypeNameMap){
        this.subjectTitle = voteSubject.getTitle();
        this.voteSubjectTypeName = subjectTypeNameMap.get(voteSubject.getVoteSubjectTypeId());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getVoteSubjectTypeName() {
        return voteSubjectTypeName;
    }

    public void setVoteSubjectTypeName(String voteSubjectTypeName) {
        this.voteSubjectTypeName = voteSubjectTypeName;
    }

    public Long getVoteSubjectNumber() {
        return voteSubjectNumber;
    }

    public void setVoteSubjectNumber(Long voteSubjectNumber) {
        this.voteSubjectNumber = voteSubjectNumber;
    }

    public Map<Long, Date> getVoteUserMap() {
        return voteUserMap;
    }

    public void setVoteUserMap(Map<Long, Date> voteUserMap) {
        this.voteUserMap = voteUserMap;
    }

    @Override
    public String toString() {
        return "VoteResultOutDTO{" +
                "id=" + id +
                ", createUserId=" + createUserId +
                ", topicTitle='" + topicTitle + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", subjectTitle='" + subjectTitle + '\'' +
                ", voteSubjectTypeName='" + voteSubjectTypeName + '\'' +
                ", voteSubjectNumber=" + voteSubjectNumber +
                ", voteUserMap=" + voteUserMap +
                '}';
    }
}
