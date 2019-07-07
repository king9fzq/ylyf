package www.codepeople.cn.service.user;

import org.springframework.stereotype.Service;
import www.codepeople.cn.dao.user.Permission;
import www.codepeople.cn.dao.user.PermissionMapper;
import www.codepeople.cn.service.BaseServiceImpl;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService{

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> findNameByRoleId(long roleId) {
        return permissionMapper.findNameByRoleId(roleId);
    }

    @Override
    public List<String> findNamesByUserId(long userId) {
        return permissionMapper.findNamesByUserId(userId);
    }
}
