package www.codepeople.cn.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT r.id,r.role_name FROM role r JOIN user_role ur ON r.id = ur.role_id WHERE ur.user_id = #{userId}")
    List<Role> findByUserId(long userId);

    @Select("SELECT r.`role_name` FROM role r JOIN user_role ur ON r.`id` = ur.`role_id` WHERE ur.`user_id` = #{userId}")
    List<String> findNamesByUserId(long userId);

//    @Select("SELECT r.`role_name` FROM role r JOIN user_role ur ON r.`id` = ur.`role_id` WHERE ur.`user_id` = #{userId}")
//    List<String> findNameByUserId(long userId);


}
