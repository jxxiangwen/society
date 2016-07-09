package cn.edu.shu.society.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 接收投票结果
 * Created by jxxia on 2016/7/8 0008.
 */
public class VoteResultMap implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Long, String> voteMap;

    public Map<Long, String> getVoteMap() {
        return voteMap;
    }

    public void setVoteMap(Map<Long, String> voteMap) {
        this.voteMap = voteMap;
    }
}
