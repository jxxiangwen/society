package cn.edu.shu.society.dto;

import java.io.Serializable;

/**
 * Created by jxxia on 2016/7/12 0012.
 */
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String itemTitle;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
