package ink.zyp.server.model.post;

import cn.hutool.core.util.IdUtil;
import ink.zyp.server.dto.post.PostCreate;
import ink.zyp.server.model.base.BaseModel;
import ink.zyp.server.utils.SummaryUtil;

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

    /**
     * 标签;多个标签用逗号分割
     */
    private String tags;

    /**
     * 正文摘要
     */
    private String summary;

    public Post() {
    }

    public Post(String title, String showLink, Integer status, Integer viewCount, Integer likeCount, String content, String tags, String summary) {
        this.title = title;
        this.showLink = showLink;
        this.status = status;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.content = content;
        this.tags = tags;
        this.summary = summary;
    }

    public Post(Integer id, String title, String showLink, Integer status, Integer viewCount, Integer likeCount, String content, String tags, String summary) {
        this.id = id;
        this.title = title;
        this.showLink = showLink;
        this.status = status;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.content = content;
        this.tags = tags;
        this.summary = summary;
    }

    /**
     * 将请求实体转换为实体
     * @param create 请求实体
     * @return Post
     */
    public static Post createToPost(PostCreate create) {
        //生成文章访问showLink(这里采用雪花算法)
        String showLink = IdUtil.getSnowflakeNextIdStr();

        //生成文章摘要
        String summary = SummaryUtil.getSummary(create.getContent());

        //TODO Tags处理
        return new Post(
                create.getTitle(),
                showLink,
                0,
                0,
                0,
                create.getContent(),
                create.getTags(),
                summary
        );
    }

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
