package cn.edu.shu.society.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jxxia on 2016/7/12 0012.
 */
public class SubjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long subjectId;

    private String subjectTitle;

    private String subjectTypeName;

    List<ItemDTO> item;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public List<ItemDTO> getItem() {
        return item;
    }

    public void setItem(List<ItemDTO> item) {
        this.item = item;
    }
}
