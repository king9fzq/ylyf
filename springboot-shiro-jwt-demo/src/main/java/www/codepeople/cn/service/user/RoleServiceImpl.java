package www.codepeople.cn.service.user;

import org.springframework.stereotype.Service;
import www.codepeople.cn.dao.user.Role;
import www.codepeople.cn.dao.user.RoleMapper;
import www.codepeople.cn.service.BaseServiceImpl;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByUserId(long userId) {
        return roleMapper.findByUserId(userId);
    }

    @Override
    public List<String> findNamesByUserId(long userId) {
        return roleMapper.findNamesByUserId(userId);
    }
}
