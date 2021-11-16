package com.tanjiaming99.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/16 13:48
 **/
@RestController
@Api(value = "测试", tags = "测试")
public class HealthController {
    @GetMapping("/health")
    @ApiOperation(value = "返回ok即正常")
    public String health(){
        return "ok";
    }
}
