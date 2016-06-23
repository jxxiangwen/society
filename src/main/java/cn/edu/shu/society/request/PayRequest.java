package cn.edu.shu.society.request;

/**
 * Created by 王兆杰 on 2016/3/27.
 */
public class PayRequest {

    private static final long serialVersionUID = -1L;

    private long accountId;

    private String orderNo;

    private int tradeType;

    private int bizType;

    private String paySubject;

    private int payChannelType;

    private int tradeAmount;

    private String sign;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }

    public String getPaySubject() {
        return paySubject;
    }

    public void setPaySubject(String paySubject) {
        this.paySubject = paySubject;
    }

    public int getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(int tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public int getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(int payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
