package www.codepeople.cn.dao.activiti;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorizationMapper {

    List<String> selectRoleIdsByUserId(String userId);
}