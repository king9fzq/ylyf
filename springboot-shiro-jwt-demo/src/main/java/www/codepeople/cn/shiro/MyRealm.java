package www.codepeople.cn.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import www.codepeople.cn.dao.user.User;
import www.codepeople.cn.service.user.PermissionService;
import www.codepeople.cn.service.user.RoleService;
import www.codepeople.cn.service.user.UserService;

import javax.annotation.Resource;

/**
 * @ClassName: MyRealm
 * @Description:
 * @Author fzq
 * @DateTime 2019年7月3日 下午4:31:33
 */

@Component
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Resource
	private RoleService roleService;

	@Resource
	private PermissionService permissionService;

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = JWTUtil.getUsername(principals.toString());
		User user = userService.findByName(username);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRoles(roleService.findNamesByUserId(user.getId()));
		simpleAuthorizationInfo.addStringPermissions(permissionService.findNamesByUserId(user.getId()));
		
		return simpleAuthorizationInfo;
	}

	/**
	 * 默认使用此方法进行用户正确与否验证，错误抛出异常即可
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String token = (String) authenticationToken.getCredentials();
		// 解密获得username，用于和数据库进行对比
		String username = JWTUtil.getUsername(token);
		if (username == null) {
			throw new AuthenticationException("token 无效！");
		}
		
		User user = userService.findByName(username);
		if (user == null) {
			throw new AuthenticationException("用户"+username+"不存在") ;
		}
		
		if (!JWTUtil.verify(token, username, user.getPassword())) {
			throw new AuthenticationException("账户密码错误!");
		}
		return new SimpleAuthenticationInfo(token, token, "my_realm");
	}

}
