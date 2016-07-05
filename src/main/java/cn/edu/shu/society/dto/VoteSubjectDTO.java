package cn.edu.shu.society.dto;

import java.io.Serializable;
import java.util.List;

public class VoteSubjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private Long voteSubjectTypeId;

    private Long voteTopicId;

    private Long createTime;

    private Long updateTime;

    private List<VoteItemDTO> voteItemList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getVoteSubjectTypeId() {
        return voteSubjectTypeId;
    }

    public void setVoteSubjectTypeId(Long voteSubjectTypeId) {
        this.voteSubjectTypeId = voteSubjectTypeId;
    }

    public Long getVoteTopicId() {
        return voteTopicId;
    }

    public void setVoteTopicId(Long voteTopicId) {
        this.voteTopicId = voteTopicId;
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

    public List<VoteItemDTO> getVoteItemList() {
        return voteItemList;
    }

    public void setVoteItemList(List<VoteItemDTO> voteItemList) {
        this.voteItemList = voteItemList;
    }

    @Override
    public String toString() {
        return "VoteSubjectDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", voteSubjectTypeId=" + voteSubjectTypeId +
                ", voteTopicId=" + voteTopicId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", voteItemDTOList=" + voteItemList +
                '}';
    }
}