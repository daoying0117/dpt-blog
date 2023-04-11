package ink.zyp.server.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.zyp.server.model.admin.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author daoying
 * 管理员mapper
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
