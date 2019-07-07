package www.codepeople.cn.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission>{

    @Select("SELECT p.`permission` FROM permission p JOIN  role_permission rp ON p.`id` = rp.`permission_id` WHERE rp.`role_id` = #{roleId}")
    List<String> findNameByRoleId(long roleId);

    @Select("SELECT p.`permission` FROM role r JOIN user_role ur ON r.`id` = ur.`role_id` JOIN role_permission rp ON r.`id` = rp.`role_id` JOIN permission p ON p.`id` = rp.`permission_id` WHERE ur.`user_id` = #{userId}")
    List<String> findNamesByUserId(long userId);
}
