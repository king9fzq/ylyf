package www.codepeople.cn.service.user;

import org.springframework.stereotype.Service;
import www.codepeople.cn.dao.user.User;
import www.codepeople.cn.dao.user.UserMapper;
import www.codepeople.cn.service.BaseServiceImpl;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }
}
