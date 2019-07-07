package www.codepeople.cn.service.activiti;

import org.springframework.stereotype.Service;
import www.codepeople.cn.dao.activiti.AuthorizationMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 *
 * @Auther: Ace Lee
 * @Date: 2019/3/7 16:55
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Resource
    private AuthorizationMapper authorizationMapper;

    @Override
    public List<String> selectRoleIdsByUserId(String userId) {
        return authorizationMapper.selectRoleIdsByUserId(userId);
    }
}
