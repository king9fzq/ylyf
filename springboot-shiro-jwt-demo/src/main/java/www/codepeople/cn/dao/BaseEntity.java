package www.codepeople.cn.dao;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;//主键id
    private Timestamp createTime;//创建时间
    private Timestamp updateTime;//修改时间

}
