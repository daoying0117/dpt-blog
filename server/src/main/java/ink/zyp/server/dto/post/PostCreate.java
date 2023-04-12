package ink.zyp.server.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;

@ApiModel("创建博文请求实体")
public class PostCreate {

    @ApiParam(value = "标题",required = true)
    private String title;

    @ApiParam(value = "正文",required = true)
    private String content;

    @ApiParam(value = "标签;多个标签用逗号分割")
    private String tags;

    public boolean checkParams(){
        return StringUtils.isNotBlank(title)
                && StringUtils.isNotBlank(content);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
