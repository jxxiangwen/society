package cn.edu.shu.society.dto;

import java.io.Serializable;

public class VoteSubjectResultDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long resultVoteItemId;

    private String contentResult;

    private Long voteSubjectId;

    private Long createTime;

    private Long updateTime;

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

    public Long getResultVoteItemId() {
        return resultVoteItemId;
    }

    public void setResultVoteItemId(Long resultVoteItemId) {
        this.resultVoteItemId = resultVoteItemId;
    }

    public String getContentResult() {
        return contentResult;
    }

    public void setContentResult(String contentResult) {
        this.contentResult = contentResult == null ? null : contentResult.trim();
    }

    public Long getVoteSubjectId() {
        return voteSubjectId;
    }

    public void setVoteSubjectId(Long voteSubjectId) {
        this.voteSubjectId = voteSubjectId;
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

    @Override
    public String toString() {
        return "VoteSubjectResultDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", resultVoteItemId=" + resultVoteItemId +
                ", contentResult='" + contentResult + '\'' +
                ", voteSubjectId=" + voteSubjectId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}