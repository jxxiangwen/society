package cn.edu.shu.society.enums;

/**
 * Created by jxxia on 2016/7/9 0009.
 */
public enum VoteTypeEnums {
    RADIO("单选题"),
    CHECKBOX("多选题"),
    OPINION("主观题"),
    ;
    private String type;

    VoteTypeEnums(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
