package www.codepeople.cn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import www.codepeople.cn.util.communication.Result;
import www.codepeople.cn.util.communication.ResultBuilder;
import www.codepeople.cn.util.communication.ResultCode;

import java.util.Arrays;

@Slf4j
@RestController
public class IndexController {

    @GetMapping("/index")
    @ResponseStatus(HttpStatus.OK)
    public Result index() {
        return ResultBuilder.success();
    }

    @GetMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        log.warn("进入401方法..........");
        return ResultBuilder.error(ResultCode.unauthorized);
    }

    @GetMapping("test")
    public Result test(){
        log.warn("进入到test方法...");
        return ResultBuilder.success(Arrays.asList("ss","aaa"));
    }
}
