package ink.zyp.server.controller.post;

import ink.zyp.server.common.JsonResult;
import ink.zyp.server.dto.post.PostCreate;
import ink.zyp.server.model.post.Post;
import ink.zyp.server.service.post.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 博文控制器
 * @author daoying
 */

@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    /**
     * 创建博文
     * @return JSON
     */
    @PostMapping("/createPost")
    public JsonResult createPost(@RequestBody PostCreate create){

        if (!create.checkParams()){
            return JsonResult.fail("参数错误");
        }
        Post post = Post.createToPost(create);

        if (postService.save(post)){
            return JsonResult.ok().msg("创建成功");
        }
        return JsonResult.fail("创建失败");
    }

    /**
     * 更新博文
     * @return JSON
     */
    @PostMapping("/updatePost")
    public JsonResult updatePost(){
        return JsonResult.ok();
    }

    /**
     * 删除博文
     * @return JSON
     */
    @PostMapping("/deletePost")
    public JsonResult deletePost(){
        return JsonResult.ok();
    }

    /**
     * 发布博文
     * @return JSON
     */
    @PostMapping("/publishPost")
    public JsonResult publishPost(){
        return JsonResult.ok();
    }

    /**
     * 获取博文列表
     * @return JSON
     */
    @GetMapping("/postList")
    public JsonResult postList(){
        return JsonResult.ok();
    }

    /**
     * 获取博文详情
     * @return JSON
     */
    @GetMapping("/postDetail")
    public JsonResult postDetail(){
        return JsonResult.ok();
    }
}
