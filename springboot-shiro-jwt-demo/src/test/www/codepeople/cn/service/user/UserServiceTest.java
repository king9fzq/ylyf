package www.codepeople.cn.service.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import www.codepeople.cn.dao.user.*;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private RolePermissionService rolePermissionService;

    private static final long userId = 596394055206699008L;
    private static final long roleId = 596637613167738880L;

    @Test
    public void addUser(){

        User user = new User();
        user.setUsername("jack");
        user.setPassword("123456");
        userService.insert(user);
    }

    @Test
    public void addRole(){

        Role role = new Role();
        role.setRoleName("人事");

        roleService.insert(role);
    }

    @Test
    public void addUserRole(){
        List<Role> roleList = roleService.findAll();
        for(Role role:roleList){
            UserRole userRole = new UserRole();
            userRole.setRoleId(role.getId());
            userRole.setUserId(userId);

            userRoleService.insert(userRole);
        }
    }

    @Test
    public void findRoleByUserId(){

        System.out.println(roleService.findByUserId(userId));
    }

    @Test
    public void addPermission(){

        Permission permission = new Permission();
        permission.setPermission("user:list");
        permissionService.insert(permission);
    }

    @Test
    public void addRolePermission(){
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        rolePermission.setPermissionId(597212715072618496L);
        rolePermissionService.insert(rolePermission);
    }

    @Test
    public void findNamesByRoleId(){

        System.out.println(permissionService.findNameByRoleId(roleId));
    }
}
