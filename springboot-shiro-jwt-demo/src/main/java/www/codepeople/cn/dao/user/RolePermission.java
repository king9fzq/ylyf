package www.codepeople.cn.dao.user;

import lombok.Data;
import lombok.ToString;
import www.codepeople.cn.dao.BaseEntity;

@Data
@ToString(callSuper = true)
public class RolePermission extends BaseEntity {

    private long roleId;
    private long permissionId;
}
