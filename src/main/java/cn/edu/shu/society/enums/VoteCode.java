/**
 * Created with IntelliJ IDEA.
 * UserDTO: walker
 * Date: 15/8/5
 * Time: 23:0
 * To change this template use File | Settings | File Templates.
 */

package cn.edu.shu.society.enums;

public enum VoteCode {
    VOTE_HAVE_OBJECT(2000,"该类别下有投票，不允许删除"),
    HAVE_VOTED(2001,"请勿重复投票"),
    VOTE_NOT_BEGIN(2002,"该投票还未开始"),
    VOTE_HAVE_OVERTIME(2003,"该投票已经结束"),
    VOTE_NOT_EXIST(2004,"该投票不存在"),
    VOTE_SUBJECT_NOT_EXIST(2005,"该投票选项不存在"),
    VOTE_TYPE_NOT_EXIST(2006,"投票类别不存在"),
    ;

    private int code;

    private String msg;

    private VoteCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
