package ink.zyp.server.service.post.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.zyp.server.mapper.post.PostMapper;
import ink.zyp.server.model.post.Post;
import ink.zyp.server.service.post.PostService;
import org.springframework.stereotype.Service;

/**
 * 博文service实现类
 * @author daoying
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper,Post> implements PostService {
}
