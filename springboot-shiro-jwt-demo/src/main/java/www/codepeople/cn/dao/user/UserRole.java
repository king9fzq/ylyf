package www.codepeople.cn.dao.user;

import lombok.Data;
import lombok.ToString;
import www.codepeople.cn.dao.UserEntity;

@Data
@ToString(callSuper = true)
public class UserRole extends UserEntity {
    /**
     * 角色表id
     */
    private long roleId;
}
