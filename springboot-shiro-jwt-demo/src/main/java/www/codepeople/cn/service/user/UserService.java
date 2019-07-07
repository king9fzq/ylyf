package www.codepeople.cn.service.user;


import www.codepeople.cn.dao.user.User;
import www.codepeople.cn.service.BaseService;

public interface UserService extends BaseService<User> {

    User findByName(String username);
}
