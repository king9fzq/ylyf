package www.codepeople.cn.service.user;


import www.codepeople.cn.dao.user.Role;
import www.codepeople.cn.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    List<Role> findByUserId(long userId);

    List<String> findNamesByUserId(long userId);
}
