package cn.edu.shu.society.dto;

import java.io.Serializable;
import java.util.List;

public class VoteTopicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String title;

    private Long startTime;

    private Long endTime;

    private Long voteTypeId;

    private Long createTime;

    private Long updateTime;

    private List<VoteSubjectDTO> voteSubjectList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Long getVoteTypeId() {
        return voteTypeId;
    }

    public void setVoteTypeId(Long voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public List<VoteSubjectDTO> getVoteSubjectList() {
        return voteSubjectList;
    }

    public void setVoteSubjectList(List<VoteSubjectDTO> voteSubjectList) {
        this.voteSubjectList = voteSubjectList;
    }

    @Override
    public String toString() {
        return "VoteTopicDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", voteTypeId=" + voteTypeId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", voteSubjectDTOList=" + voteSubjectList +
                '}';
    }
}