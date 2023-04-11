package ink.zyp.server.model.admin;

import ink.zyp.server.model.base.BaseModel;

/**
 * 博文实体
 * @author daoying
 */
public class Post extends BaseModel {
    /**
     * id
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 展示链接
     */
    private String showLink;

    /**
     * 状态 0:初始化; 1: 发布,-1: 下线
     */
    private Integer status;

    /**
     * 查看数
     */
    private Integer viewCount;

    /**
     * 喜欢数
     */
    private Integer likeCount;

    /**
     * 正文
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowLink() {
        return showLink;
    }

    public void setShowLink(String showLink) {
        this.showLink = showLink;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
