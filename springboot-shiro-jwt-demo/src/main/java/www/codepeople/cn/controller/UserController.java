package www.codepeople.cn.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import www.codepeople.cn.dao.user.User;
import www.codepeople.cn.dto.UserInDto;
import www.codepeople.cn.service.user.UserService;
import www.codepeople.cn.shiro.JWTUtil;
import www.codepeople.cn.util.communication.ResultBuilder;
import www.codepeople.cn.util.communication.Result;
import www.codepeople.cn.util.exception.UserNamePwdErrorException;

/**
 * @ClassName: UserController
 * @Description: 
 * @Author fzq
 * @DateTime 2019年7月3日 下午5:29:03
 */

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value="登录功能", notes="用户密码登录")
	@ApiImplicitParams({
         @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
         @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
	 })

	@PostMapping("/login")
	public Result login(@RequestBody UserInDto userInDto){
		String username = userInDto.getUsername();
		String password = userInDto.getPassword();

		User user = userService.findByName(username);
		if(null==user)throw UserNamePwdErrorException.build();
		if (!user.getPassword().equals(password)) throw UserNamePwdErrorException.build();

		String token = JWTUtil.sign(username, password);
		return ResultBuilder.success(token);
	}

	@RequiresPermissions("user:list")
	@GetMapping("/list")
	@ApiOperation(value="获取用户列表", notes="获取用户列表")
	public Result list() throws UnsupportedEncodingException {
		List<User> listUser = userService.findAll();
		return ResultBuilder.success(listUser);
	}

	@GetMapping("/findOwn")
	public Result findOwn(){

		User user = userService.findById(596394055206699008L);
		return ResultBuilder.success(user);
	}
}
