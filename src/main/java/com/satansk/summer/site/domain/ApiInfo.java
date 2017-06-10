package com.satansk.summer.site.domain;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
public class ApiInfo {
    /**
     * API 文档的版本
     */
    private String version;

    /**
     * API 文档名字
     */
    private String title;

    /**
     * API 描述信息
     */
    private String description;

    /********************************* Getter/Setter **********************************/

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /********************************* toString **********************************/

    @Override
    public String toString() {
        return "ApiInfo [version=" + version + ", title=" + title + ", description=" + description + "]";
    }
}
