package cn.edu.shu.society.enums;

/**
 * Created by jxxia on 2016/7/2 0002.
 */
public enum DefaultPage {
    ERROR_404_PAGE("/WEB-INF/error/404.jsp"),
    ERROR_500_PAGE("/WEB-INF/error/500.jsp"),
    INDEX_PAGE("index.jsp"),
    ;
    private String page;

    DefaultPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
