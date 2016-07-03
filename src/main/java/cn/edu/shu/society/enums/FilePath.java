package cn.edu.shu.society.enums;

/**
 * Created by jxxia on 2016/7/2 0002.
 */
public enum FilePath {
    OFFICE("\\file\\office\\"),
    TEXT("\\file\\text\\"),
    FILE("\\file\\"),
    TEMP("\\temp\\"),
    ;
    private String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
