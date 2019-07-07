package www.codepeople.cn.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import www.codepeople.cn.dao.BaseEntity;
import www.codepeople.cn.util.SnowflakeIdWorker;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired(required = false)
    private BaseMapper<T> baseMapper;

    public int insert(T var1){
        var1.setId(SnowflakeIdWorker.nextId());
        Timestamp time = new Timestamp(System.currentTimeMillis());
        var1.setUpdateTime(time);
        var1.setCreateTime(time);
        return baseMapper.insert(var1);
    };

    public T findById(Serializable id){

        return baseMapper.selectById(id);
    }

    public List<T> findAll(){

        return baseMapper.selectList(null);
    }
}
