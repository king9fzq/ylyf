package www.codepeople.cn.service.activiti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.codepeople.cn.dao.activiti.ProcessMapper;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @Auther: Ace Lee
 * @Date: 2019/3/7 16:55
 */
@Service
public class ProcessInfoServiceImpl implements ProcessInfoService {

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public List<Map<String, Object>> models() {
        return processMapper.selectModels();
    }

    @Override
    public List<Map<String, Object>> process() {
        return processMapper.selectProcess();
    }

}
