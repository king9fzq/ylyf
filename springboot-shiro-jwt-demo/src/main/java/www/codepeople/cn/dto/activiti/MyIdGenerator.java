package www.codepeople.cn.dto.activiti;

import org.activiti.engine.impl.cfg.IdGenerator;
import www.codepeople.cn.util.SnowflakeIdWorker;

public class MyIdGenerator implements IdGenerator {
    @Override
    public String getNextId() {
        return String.valueOf(SnowflakeIdWorker.nextId());
    }
}