package cn.edu.shu.society.response;

public class PayResponse extends ResultResponse {

    private int payChannelType;

    private String payInfo;

    public int getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(int payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }
}
