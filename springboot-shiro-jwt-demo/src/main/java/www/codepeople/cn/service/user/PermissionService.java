package www.codepeople.cn.service.user;


import www.codepeople.cn.dao.user.Permission;
import www.codepeople.cn.service.BaseService;

import java.util.List;

public interface PermissionService extends BaseService<Permission> {

    List<String> findNameByRoleId(long roleId);

    List<String> findNamesByUserId(long userId);
}
