package cn.edu.shu.society.entity;

import java.util.List;

public class VoteTopic {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.id
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.user_id
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.title
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.start_time
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.end_time
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.vote_type_id
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long voteTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.create_time
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vote_topic.update_time
     *
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    private Long updateTime;

    private List<VoteSubject> voteSubjectList;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.id
     *
     * @return the value of vote_topic.id
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.id
     *
     * @param id the value for vote_topic.id
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.user_id
     *
     * @return the value of vote_topic.user_id
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.user_id
     *
     * @param userId the value for vote_topic.user_id
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.title
     *
     * @return the value of vote_topic.title
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.title
     *
     * @param title the value for vote_topic.title
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.start_time
     *
     * @return the value of vote_topic.start_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.start_time
     *
     * @param startTime the value for vote_topic.start_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.end_time
     *
     * @return the value of vote_topic.end_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.end_time
     *
     * @param endTime the value for vote_topic.end_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.vote_type_id
     *
     * @return the value of vote_topic.vote_type_id
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getVoteTypeId() {
        return voteTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.vote_type_id
     *
     * @param voteTypeId the value for vote_topic.vote_type_id
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setVoteTypeId(Long voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.create_time
     *
     * @return the value of vote_topic.create_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.create_time
     *
     * @param createTime the value for vote_topic.create_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vote_topic.update_time
     *
     * @return the value of vote_topic.update_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vote_topic.update_time
     *
     * @param updateTime the value for vote_topic.update_time
     * @mbggenerated Sun Jul 03 18:10:29 CST 2016
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public List<VoteSubject> getVoteSubjectList() {
        return voteSubjectList;
    }

    public void setVoteSubjectList(List<VoteSubject> voteSubjectList) {
        this.voteSubjectList = voteSubjectList;
    }
}