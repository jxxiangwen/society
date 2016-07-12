package cn.edu.shu.society.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jxxia on 2016/7/12 0012.
 */
public class TopicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long topicId;

    private String topicTitle;

    private String topicTypeName;

    private Date topicStartTime;

    private Date topicEndTime;

    List<SubjectDTO> subject;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicTypeName() {
        return topicTypeName;
    }

    public void setTopicTypeName(String topicTypeName) {
        this.topicTypeName = topicTypeName;
    }

    public List<SubjectDTO> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectDTO> subject) {
        this.subject = subject;
    }

    public Date getTopicStartTime() {
        return topicStartTime;
    }

    public void setTopicStartTime(Date topicStartTime) {
        this.topicStartTime = topicStartTime;
    }

    public Date getTopicEndTime() {
        return topicEndTime;
    }

    public void setTopicEndTime(Date topicEndTime) {
        this.topicEndTime = topicEndTime;
    }
}
