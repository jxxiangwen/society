package cn.edu.shu.society.dto;

import java.io.Serializable;

public class VoteItemDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private Long voteSubjectId;

    private Long createTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        return "VoteItemDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", voteSubjectId=" + voteSubjectId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}