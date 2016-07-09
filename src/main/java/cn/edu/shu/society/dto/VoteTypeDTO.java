package cn.edu.shu.society.dto;

import java.io.Serializable;

public class VoteTypeDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String typeName;

    private String parentTypeName;

    private Long createTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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

    public String getParentTypeName() {
        return parentTypeName;
    }

    public void setParentTypeName(String parentTypeName) {
        this.parentTypeName = parentTypeName;
    }

    @Override
    public String toString() {
        return "VoteTypeDTO{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", parentTypeName='" + parentTypeName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}