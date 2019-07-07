package www.codepeople.cn.service.activiti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuntimeInfoServiceTest {

    @Resource
    private RuntimeInfoService runtimeInfoService;

    @Test
    public void rejected() {

        String taskId = "";
        String rejectElemKey = "qj";
        String dealReason = "任性就是要回退!";

        runtimeInfoService.rejected(taskId,rejectElemKey,dealReason);

    }
}