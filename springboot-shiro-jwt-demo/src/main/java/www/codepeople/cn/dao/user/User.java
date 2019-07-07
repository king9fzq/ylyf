package www.codepeople.cn.dao.user;

import lombok.Data;
import lombok.ToString;
import www.codepeople.cn.dao.BaseEntity;

@Data
@ToString(callSuper = true)
public class User extends BaseEntity {

    private String username;//用户名
    private String password;//密码
}
