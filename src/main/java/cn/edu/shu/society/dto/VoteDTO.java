package cn.edu.shu.society.dto;

/**
 * Created by jxxia on 2016/7/5 0005.
 */
public class VoteDTO {
    private static final long serialVersionUID = 1L;

    private Long voteObjectId;

    private String result;

    public Long getVoteObjectId() {
        return voteObjectId;
    }

    public void setVoteObjectId(Long voteObjectId) {
        this.voteObjectId = voteObjectId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "voteObjectId=" + voteObjectId +
                ", result='" + result + '\'' +
                '}';
    }
}
