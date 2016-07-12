package cn.edu.shu.society.dto;

import java.io.Serializable;

/**
 * Created by jxxia on 2016/7/12 0012.
 */
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ItemId;
    private String itemTitle;

    public String getItemTitle() {
        return itemTitle;
    }

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
